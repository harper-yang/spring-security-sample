package harper.github.io;// Demo05ProducerTest.java

import harper.github.io.demo05.Demo05Producer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MqApplication.class)
@Slf4j
public class Demo05ProducerTest {

    @Autowired
    private Demo05Producer producer;


    // 因为使用 BatchingRabbitTemplate 批量发送消息，所以在 Producer 成功发送完第一条消息后，Consumer 并未消费到这条消息。
    // 又因为 BatchingRabbitTemplate 是按照每次发送后，都重新计时，所以在最后一条消息成功发送后的 30 秒，Consumer 才消费到批量发送的 3 条消息。
    @Test
    public void testSyncSend() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            // 同步发送消息
            int id = (int) (System.currentTimeMillis() / 1000);
            producer.syncSend(id);

            // 故意每条消息之间，隔离 10 秒
            log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
//            Thread.sleep(10 * 1000L);
        }

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}