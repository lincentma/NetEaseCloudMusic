package dao;

import dao.annotation.ColumnInfo;
import dao.annotation.TableInfo;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JdbcUtil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ml on 2017/7/19.
 */

public class BaseDao<T> {

    // 保存当前运行类的参数化类型中的实际的类型
    private Class clazz;
    // 表名 约定表名就是实体类名 -- PS：这种约定俗成不太友好，还是用注解去获取指定的比较nice
    private String tableName;
    //所有的字段
    private Field[] fields;

    private String primaryKey;//主键

    // 构造函数： 1. 获取当前运行类的参数化类型；
    // 2. 获取参数化类型中实际类型的定义(class)
    public BaseDao() {
        // this 表示当前运行类 (AccountDao/AdminDao)
        // this.getClass() 当前运行类的字节码对象(AccountDao.class/AdminDao.class)
        // this.getClass().getGenericSuperclass(); 当前运行类的父类，即为BaseDao<Account>
        // 其实就是“参数化类型”， ParameterizedType

        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
        Type type = this.getClass().getGenericSuperclass();
        // 强制转换为“参数化类型” 【BaseDao<Account>】
        ParameterizedType pt = (ParameterizedType) type;

        // Class类是Type接口的实现类
        // 获取参数化类型中，实际类型的定义 【new Type[]{Account.class}】
        Type types[] = pt.getActualTypeArguments();
        // 获取数据的第一个元素：Accout.class
        clazz = (Class) types[0];

        //tableName = clazz.getSimpleName();//获取类名（不带包名）表名 (与类名一样，只要获取类名就可以)
        TableInfo tab = (TableInfo) clazz.getAnnotation(TableInfo.class); //获取注解中的表的名称
        tableName = tab.TableName();
        primaryKey = tab.PrimaryKey();
        fields = clazz.getDeclaredFields();

    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<T> findAll() {
        String sql = "select * from " + tableName;
        System.out.println(sql);
        try {
            return JdbcUtil.getQueryRunner().query(sql, new BeanListHandler<T>(clazz));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 保存
     *
     * @param t 要保存的实体对象
     * @return boolean
     */
    public boolean save(T t) {
        boolean flag = false;
        try {
            List<Object> params = new ArrayList<Object>();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);//强制是有字段也可以访问
                params.add(fields[i].get(t));
            }
            //sql拼接
            StringBuilder sql = new StringBuilder();
            sql.append("insert into " + tableName + "(");
            for (int j = 0; j < fields.length; j++) {
                String fieldName = fields[j].getAnnotation(ColumnInfo.class).columnName();//获取表字段名
                if (j == fields.length - 1) {
                    sql.append(fieldName + ")");
                } else {
                    sql.append(fieldName + ",");
                }
            }
            sql.append(" values(");
            for (int k = 0; k < fields.length; k++) {
                if (k == fields.length - 1) {
                    sql.append("?)");
                } else {
                    sql.append("?,");
                }
            }
            sql.append(" ON DUPLICATE KEY UPDATE ");
            for (int l = 0; l < fields.length; l++) {
                String fieldName = fields[l].getAnnotation(ColumnInfo.class).columnName();//获取表字段名
                if (l == fields.length - 1) {
                    sql.append(fieldName + " = values(" + fieldName + ")");
                } else {
                    sql.append(fieldName + " = values(" + fieldName + "),");
                }
            }
            System.out.println(sql);
            JdbcUtil.getQueryRunner().insert(sql.toString()
                    , new MBeanHandler<T>(clazz, mMethod.INSERT)
                    , params.toArray());
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return flag;
    }

    enum mMethod {
        SELECT,
        INSERT,
        UPDATE
    }

    /**
     * 自定义结果集：封装单个Bean对象
     *
     * @param <T>
     * @author fnz
     */
    class MBeanHandler<T> implements ResultSetHandler<T> {
        private mMethod method;
        private Class<T> clazz;

        public MBeanHandler(Class<T> clazz, mMethod method) {
            this.clazz = clazz;
            this.method = method;
        }

        public T handle(ResultSet rs) throws SQLException {
            try {
                if (this.method == mMethod.SELECT) {
                    if (rs.next()) {
                        T tobj = clazz.newInstance();
                        Field[] fields = clazz.getDeclaredFields();//获取到所有的
                        for (Field field : fields) {
                            ColumnInfo col = field.getAnnotation(ColumnInfo.class);//获取实体类字段上的注解ColumnInfo
                            String colName = col.columnName();//得到 实体类字段 对应 表的字段名
                            //获取表字段的值
                            rs.findColumn(colName);
                            Object value = rs.getObject(colName);
                            //封装对象
                            field.setAccessible(true);
                            field.set(tobj, value);
                        }
                        return tobj;
                    }
                } else {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return null;
        }
    }
}