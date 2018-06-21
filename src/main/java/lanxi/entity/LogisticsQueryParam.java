package lanxi.entity;

import com.lanxi.assist.AbstractParam;

import java.util.TreeMap;

/**
 * Created by wuxiaobo on 2018/6/19 0019.
 */
public class LogisticsQueryParam extends AbstractParam{
    //订单编号
    private String orderId;
    //供应商编号
    private String supplyChannel;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSupplyChannel() {
        return supplyChannel;
    }

    public void setSupplyChannel(String supplyChannel) {
        this.supplyChannel = supplyChannel;
    }

    @Override
    public TreeMap<String, String> toSign() {
        return super.toSign();
    }

    @Override
    public TreeMap<String, String> toTreeMap() {
        TreeMap<String, String> treeMap = super.toTreeMap();
        treeMap.put("orderId",orderId);
        treeMap.put("supplyChannel",supplyChannel);
        return treeMap;
    }

    @Override
    public TreeMap<String, String> toEncryptTreeMap() {
        return super.toEncryptTreeMap();
    }

    @Override
    public String toString() {
        return "LogisticsQueryParam{" +
                "orderId='" + orderId + '\'' +
                ", supplyChannel='" + supplyChannel + '\'' +
                ", appKey='" + appKey + '\'' +
                ", channelId='" + channelId + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
