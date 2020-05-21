package harper.github.io.module.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

/**
 * 条件装配的condition
 *
 * @Project OnSystemPropertyCondition(harper.github.io.module.condition)
 * @Author  Harper Yang
 * @Date    2020/2/6 18:06
 * @Version v1.6.0
 */
public class OnSystemPropertyCondition implements Condition {



    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        MultiValueMap<String, Object> attributes =
                metadata.getAllAnnotationAttributes(ConditionOnSystemProperty.class.getName());

        String propertyName = (String) attributes.getFirst("name");
        String propertyValue = (String) attributes.getFirst("value");

        String systemPropertyValue = System.getProperty(propertyName);
        if (Objects.equals(systemPropertyValue, propertyValue)) {
            System.out.printf("系统属性【名称:%s】找到匹配值：%s\n", propertyName, propertyValue);

            return true;
        }

        return false;
    }
}
