package harper.github.io.demo09;// ClusteringMessage.java

import lombok.Data;

import java.io.Serializable;
/**
 * 集群消费message
 *
 * @Project ClusteringMessage(harper.github.io.demo09)
 * @Author  Harper Yang
 * @Date    2020/5/23 0:03
 * @Version v2.5.0
 */
@Data
public class ClusteringMessage implements Serializable {

    public static final String QUEUE = "QUEUE_CLUSTERING";

    public static final String EXCHANGE = "EXCHANGE_CLUSTERING";

    /**
     * 编号
     */
    private Integer id;

    // ... 省略 set/get/toString 方法

}