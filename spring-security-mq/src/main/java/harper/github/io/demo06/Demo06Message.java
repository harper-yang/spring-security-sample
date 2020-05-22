package harper.github.io.demo06;

import lombok.Data;

import java.io.Serializable;

/**
 * 批量发送消息的message实体
 *
 * @Project Demo05Message(harper.github.io.demo05)
 * @Author  Harper Yang
 * @Date    2020/5/22 0:37
 * @Version v2.5.0
 */
@Data
public class Demo06Message implements Serializable {

    public static final String QUEUE = "QUEUE_DEMO_06";

    public static final String EXCHANGE = "EXCHANGE_DEMO_06";

    public static final String ROUTING_KEY = "ROUTING_KEY_06";

    /**
     * 编号
     */
    private Integer id;
}
