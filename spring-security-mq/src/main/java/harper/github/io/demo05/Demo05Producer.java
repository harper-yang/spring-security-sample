package harper.github.io.demo05;

import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo05Producer {

    @Autowired
    private BatchingRabbitTemplate batchingRabbitTemplate;


    public void syncSend(Integer id) {
        Demo05Message message = new Demo05Message();
        message.setId(id);

        batchingRabbitTemplate.convertAndSend(Demo05Message.EXCHANGE, Demo05Message.ROUTING_KEY, message);

    }

}
