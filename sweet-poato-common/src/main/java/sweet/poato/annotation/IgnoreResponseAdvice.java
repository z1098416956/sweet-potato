package sweet.poato.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 统一返回包装标识注解
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {

    /**
     * 是否进行全局异常处理封装
     * @return true:进行处理;  false:不进行异常处理
     */
    boolean errorDispose() default true;

}
