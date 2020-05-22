package harper.github.io.demo2;

import harper.github.io.demo.Demo01Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Demo02Message.QUEUE) // 声明了消费的队列是Demo01 QUEUE
@Slf4j
public class Demo02Consumer {

    // 声明了处理消息的方法 方法入参为消息的类型
    @RabbitHandler
    public void onMessage(Demo02Message message) {


        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);

    }

}
