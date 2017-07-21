package utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;


/**
 * Created by ml on 2017/7/19.
 */

public class JdbcUtil {
    private static ComboPooledDataSource dataSource = null;

    static {
        //初始化操作
        // 自动加载c3p0的配置文件【c3p0-config.xml】
        dataSource = new ComboPooledDataSource();// 使用默认的配置
    }

    //获取QueryRunner对象
    public static QueryRunner getQueryRunner() {
        return new QueryRunner(dataSource);
    }

    //获取连接 通过c3p0核心类对象获取(此例子没用到该方法)
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}


//public class JdbcUtil {
//    // 数据库驱动
//    private static String Driver = "";
//    // 数据库地址
//    private static String url = "";
//    // 数据库用户名
//    private static String userName = "";
//    // 数据库密码
//    private static String password = "";
//
//    //加载类时，先将jdbc链接数据库信息获取并赋值
//    static {
//        Properties prop = new Properties();
//        InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("src/main/resources/jdbc.properties");
//        try {
//            prop.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        url = prop.getProperty("url");
//        userName = prop.getProperty("user");
//        password = prop.getProperty("pass");
//        Driver = prop.getProperty("driver");
//    }
//
//    static {
//        try {
//            Class.forName(Driver);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Connection getConn() {
//        Connection conn = null;
//        try {
//            // 加载驱动
//            Class.forName(Driver);
//            // 获取数据库连接
//            conn = DriverManager.getConnection(url, userName, password);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//
//    // 关闭数据库资源
//    public static void closeAll(ResultSet rs, Statement stat, Connection conn) {
//        /* 分别按顺序关闭数据库的结果集资源，Statement 对象资源以及Connection 连接数据库对象 */
//        if (rs != null) {
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (stat != null) {
//            try {
//                stat.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    public static String getDriver() {
//        return Driver;
//    }
//
//    public static void setDriver(String driver) {
//        Driver = driver;
//    }
//
//    public static String getUrl() {
//        return url;
//    }
//
//    public static void setUrl(String url) {
//        JdbcUtil.url = url;
//    }
//
//    public static String getUserName() {
//        return userName;
//    }
//
//    public static void setUserName(String userName) {
//        JdbcUtil.userName = userName;
//    }
//
//    public static String getPassword() {
//        return password;
//    }
//
//    public static void setPassword(String password) {
//        JdbcUtil.password = password;
//    }
//}
