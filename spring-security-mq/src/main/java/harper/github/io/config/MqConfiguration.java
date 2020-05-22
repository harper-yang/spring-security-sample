package harper.github.io.config;

import harper.github.io.demo.Demo01Message;
import harper.github.io.demo03.Demo03Message;
import harper.github.io.demo2.Demo02Message;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfiguration {

    public static class DirectExchangeDemoConfiguration {

        /**
         * 创建queue
         * @return
         */
        @Bean
        public Queue demo01Queue() {

            return new Queue(Demo01Message.QUEUE, true, false, false);
        }

        /**
         * 创建 direct queue
         * @return
         */
        @Bean
        public DirectExchange demo01Exchange() {

            return new DirectExchange(Demo01Message.EXCHANGE, true, false);
        }

        /**
         * 创建binding
         * @return
         */
        @Bean
        public Binding demo01Binding() {

            return BindingBuilder.bind(demo01Queue()).to(demo01Exchange()).with(Demo01Message.ROUTING_KEY);
        }

        @Bean
        public AsyncRabbitTemplate asyncRabbitTemplate(RabbitTemplate rabbitTemplate){
            return new AsyncRabbitTemplate(rabbitTemplate);
        }
    }


    public static class TopicExchangeConfiguration {

        @Bean
        public Queue demo02Queue() {
            return new Queue(Demo02Message.QUEUE, true, false, false);
        }

        @Bean
        public TopicExchange demo02Exchange() {

            return new TopicExchange(Demo02Message.EXCHANGE, true, false);
        }

        @Bean
        public Binding demo02Binding() {
            return BindingBuilder.bind(demo02Queue()).to(demo02Exchange()).with(Demo02Message.ROUTING_KEY);
        }

    }

    /**
     * Fanout Exchange 示例的配置类
     */
    public static class FanoutExchangeDemoConfiguration {

        // 创建 Queue A
        @Bean
        public Queue demo03QueueA() {
            return new Queue(Demo03Message.QUEUE_A, // Queue 名字
                    true, // durable: 是否持久化
                    false, // exclusive: 是否排它
                    false); // autoDelete: 是否自动删除
        }

        // 创建 Queue B
        @Bean
        public Queue demo03QueueB() {
            return new Queue(Demo03Message.QUEUE_B, // Queue 名字
                    true, // durable: 是否持久化
                    false, // exclusive: 是否排它
                    false); // autoDelete: 是否自动删除
        }

        // 创建 Fanout Exchange
        @Bean
        public FanoutExchange demo03Exchange() {
            return new FanoutExchange(Demo03Message.EXCHANGE,
                    true,  // durable: 是否持久化
                    false);  // exclusive: 是否排它
        }

        // 创建 Binding A
        // Exchange：Demo03Message.EXCHANGE
        // Queue：Demo03Message.QUEUE_A
        @Bean
        public Binding demo03BindingA() {
            return BindingBuilder.bind(demo03QueueA()).to(demo03Exchange());
        }

        // 创建 Binding B
        // Exchange：Demo03Message.EXCHANGE
        // Queue：Demo03Message.QUEUE_B
        @Bean
        public Binding demo03BindingB() {
            return BindingBuilder.bind(demo03QueueB()).to(demo03Exchange());
        }

    }
}
