package harper.github.io.module.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 实现条件装配的configuration
 *
 * @Project ConditionMessageConfiguration(harper.github.io.module.condition)
 * @Author  Harper Yang
 * @Date    2020/2/6 18:06
 * @Version v1.6.0
 */
@Configuration
public class ConditionMessageConfiguration {

    @Bean("message")
    @ConditionOnSystemProperty(name = "language",value = "chinese")
    public String chineseMessage() {
        return "你好，世界";
    }


    @Bean("message")
    @ConditionOnSystemProperty(name = "language",value = "english")
    public String englishMessage() {
        return "hello world";
    }

}
