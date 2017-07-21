package dao.annotation;

/**
 * Created by ml on 2017/7/19.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * 用于标识表字段名
 */

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnInfo {
    String columnName();
}
