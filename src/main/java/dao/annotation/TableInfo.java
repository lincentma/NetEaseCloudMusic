package dao.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;


/**
 * Created by ml on 2017/7/19.
 */

/**
 * TableName对应表名称
 * PrimaryKey对应主键字段名
 */

@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TableInfo {

    public String TableName();

    public String PrimaryKey();

}
