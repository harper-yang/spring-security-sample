package harper.github.io.module.condition;


import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 条件装配注解
 *
 * @Project ConditionOnSystemProperty(harper.github.io.module.condition)
 * @Author  Harper Yang
 * @Date    2020/2/6 18:06
 * @Version v1.6.0
 */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionOnSystemProperty {

    String name();

    String value();
}
