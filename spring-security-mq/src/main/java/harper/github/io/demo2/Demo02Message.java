package harper.github.io.demo2;

import lombok.Data;

import java.io.Serializable;

@Data
public class Demo02Message implements Serializable {


    public static final String QUEUE = "QUEUE_DEMO_02";

    public static final String EXCHANGE = "EXCHANGE_DEMO_02";

    // 匹配以housing.worker结尾的，任意单词开头的
    public static final String ROUTING_KEY = "#.housing.worker";

    /**
     * 编号
     */
    private Integer id;
}
