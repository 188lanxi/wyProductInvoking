package lanxi.entity;

import com.alibaba.fastjson.JSON;
import com.lanxi.assist.AbstractParam;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by wuxiaobo on 2018/6/19 0019.
 */
public class BookOrderParam extends AbstractParam{
    //订单编号
    private String orderId;
    //供应商编号
    private String supplyChannel;
    private UserInfo userInfo;
    private List<OrderItem> orderItemList;

    @Override
    public TreeMap<String, String> toSign() {
        return super.toSign();
    }

    @Override
    public TreeMap<String, String> toTreeMap() {
        TreeMap<String, String> treeMap = super.toTreeMap();
        treeMap.put("orderId",orderId);
        treeMap.put("supplyChannel",supplyChannel);
        treeMap.put("userInfo", JSON.toJSONString(userInfo));
        treeMap.put("orderItemList", JSON.toJSONString(orderItemList));
        return treeMap;
    }

    @Override
    public TreeMap<String, String> toEncryptTreeMap() {
        return super.toEncryptTreeMap();
    }

    @Override
    public String toString() {
        return "BookOrderParam{" +
                "orderId='" + orderId + '\'' +
                ", appKey='" + appKey + '\'' +
                ", supplyChannel='" + supplyChannel + '\'' +
                ", channelId='" + channelId + '\'' +
                ", userInfo=" + userInfo +
                ", sign='" + sign + '\'' +
                ", orderItemList=" + orderItemList +
                '}';
    }

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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
