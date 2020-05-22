package harper.github.io.demo03;

import lombok.Data;

import java.io.Serializable;

@Data
public class Demo03Message implements Serializable {

    public static final String QUEUE_A = "QUEUE_DEMO_03_A";
    public static final String QUEUE_B = "QUEUE_DEMO_03_B";

    public static final String EXCHANGE = "EXCHANGE_DEMO_03";

    /**
     * 编号
     */
    private Integer id;

    // ... 省略 set/get/toString 方法

}