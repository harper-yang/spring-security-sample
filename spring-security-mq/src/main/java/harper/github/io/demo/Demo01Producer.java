package harper.github.io.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * 消息生产者 发送队列消息
 *
 * @Project Demo01Producer(harper.github.io.demo)
 * @Author  Harper Yang
 * @Date    2020/5/21 23:48
 * @Version v2.5.0
 */
@Component
@Slf4j
public class Demo01Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AsyncRabbitTemplate asyncRabbitTemplate;

    public void syncSend(Integer id) {
        // 创建消息
        Demo01Message demo01 = new Demo01Message();
        demo01.setId(id);

        // 同步发送消息
        rabbitTemplate.convertAndSend(Demo01Message.EXCHANGE, Demo01Message.ROUTING_KEY, demo01);

    }

    public void syncSendDefault(Integer id) {
        Demo01Message demo01Message = new Demo01Message();
        demo01Message.setId(id);

        // 同步发送消息
        rabbitTemplate.convertAndSend(Demo01Message.QUEUE, demo01Message);
    }

    public void asyncSend(Integer id) {
        // 创建消息
        Demo01Message demo01 = new Demo01Message();
        demo01.setId(id);

        String content = "I am async msg!";
        log.info("########### send : {}", content);

        AsyncRabbitTemplate.RabbitConverterFuture<Object> future = asyncRabbitTemplate
                .convertSendAndReceive(Demo01Message.EXCHANGE, Demo01Message.ROUTING_KEY, demo01);

        future.addCallback(new ListenableFutureCallback<Object>() {
            @Override
            public void onFailure(Throwable throwable) {
            }
            @Override
            public void onSuccess(Object o) {
                System.out.println("success : " + o);
            }
        });

    }
}
