package harper.github.io.config;

import harper.github.io.demo06.Demo06Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Demo06Configuration {

    // 创建 Queue
    @Bean
    public Queue demo06Queue() {
        return new Queue(Demo06Message.QUEUE, // Queue 名字
                true, // durable: 是否持久化
                false, // exclusive: 是否排它
                false); // autoDelete: 是否自动删除
    }

    // 创建 Direct Exchange
    @Bean
    public DirectExchange demo06Exchange() {
        return new DirectExchange(Demo06Message.EXCHANGE,
                true,  // durable: 是否持久化
                false);  // exclusive: 是否排它
    }

    // 创建 Binding
    // Exchange：Demo06Message.EXCHANGE
    // Routing key：Demo06Message.ROUTING_KEY
    // Queue：Demo06Message.QUEUE
    @Bean
    public Binding demo06Binding() {
        return BindingBuilder.bind(demo06Queue()).to(demo06Exchange()).with(Demo06Message.ROUTING_KEY);
    }

    @Bean("consumerBatchContainerFactory")
    public SimpleRabbitListenerContainerFactory consumerBatchContainerFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory factory

            ) {
        // 创建 SimpleRabbitListenerContainerFactoryConfiguration 对象
        SimpleRabbitListenerContainerFactory containerFactory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(containerFactory, factory);
        containerFactory.setBatchListener(true);
        containerFactory.setBatchSize(10);
        containerFactory.setReceiveTimeout(10000L);
        containerFactory.setConsumerBatchEnabled(true);
        return containerFactory;
    }
}
