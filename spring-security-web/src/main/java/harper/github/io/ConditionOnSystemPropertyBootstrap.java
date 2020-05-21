package harper.github.io;

import harper.github.io.module.condition.ConditionMessageConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 条件装配引导程序
 *
 * @Project ConditionOnSystemPropertyBootstrap(harper.github.io)
 * @Author  Harper Yang
 * @Date    2020/2/6 18:05
 * @Version v1.6.0
 */
public class ConditionOnSystemPropertyBootstrap {


    public static void main(String[] args) {

        System.setProperty("language", "english");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConditionMessageConfiguration.class);

        context.refresh();

        String message = context.getBean("message", String.class);
        System.out.printf("message:%s", message);
    }
}
