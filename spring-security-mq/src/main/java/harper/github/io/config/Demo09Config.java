package harper.github.io.config;

import harper.github.io.demo09.ClusteringMessage;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Demo09Config {

    /**
     * 集群消费的示例的配置
     */
    public static class ClusteringConfiguration {

        // 创建 Topic Exchange
        @Bean
        public TopicExchange clusteringExchange() {
            return new TopicExchange(ClusteringMessage.EXCHANGE,
                    true,  // durable: 是否持久化
                    false);  // exclusive: 是否排它
        }

    }

}
