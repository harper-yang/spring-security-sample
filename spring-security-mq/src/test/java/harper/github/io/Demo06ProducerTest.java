package harper.github.io;// Demo06ProducerTest.java

import harper.github.io.demo06.Demo06Producer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

/**
 * 批量消费 测试
 *
 * @Project Demo06ProducerTest(harper.github.io)
 * @Author  Harper Yang
 * @Date    2020/5/22 23:15
 * @Version v2.5.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MqApplication.class)
@Slf4j
public class Demo06ProducerTest {

    @Autowired
    private Demo06Producer producer;

    @Test
    public void testSyncSend01() throws InterruptedException {
        // 发送 3 条消息
        this.testSyncSend(3);
    }

    @Test
    public void testSyncSen02() throws InterruptedException {
        // 发送 10 条消息
        this.testSyncSend(10);
    }

    private void testSyncSend(int n) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // 同步发送消息
            int id = (int) (System.currentTimeMillis() / 1000);
            producer.syncSend(id);
            log.info("[testSyncSendMore][发送编号：[{}] 发送成功]", id);
        }

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}