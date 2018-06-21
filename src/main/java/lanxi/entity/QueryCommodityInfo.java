package lanxi.entity;

import com.lanxi.assist.AbstractParam;
import com.lanxi.util.AESDecodeUtil;
import com.lanxi.util.SignUtil;

import java.util.TreeMap;

/**
 * Created by wuxiaobo on 2018/6/19 0019.
 */
public class QueryCommodityInfo extends AbstractParam{
    //商品goodsId
    private String goodsId;
    //商品skuId
    private String skuId;
    //商品供应商编号
    private String supplyChannel;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSupplyChannel() {
        return supplyChannel;
    }

    public void setSupplyChannel(String supplyChannel) {
        this.supplyChannel = supplyChannel;
    }

    @Override
    public TreeMap<String, String> toTreeMap() {
        TreeMap<String, String> treeMap = super.toTreeMap();
        treeMap.put("goodsId",goodsId);
        treeMap.put("skuId",skuId);
        treeMap.put("supplyChannel",supplyChannel);
        return treeMap;
    }

    @Override
    public TreeMap<String, String> toSign() {
        TreeMap<String, String> treeMap = toTreeMap();
        String sign = SignUtil.toSign(treeMap);
        treeMap.put("sign",sign);
        return treeMap;
    }

    @Override
    public TreeMap<String, String> toEncryptTreeMap() {
        TreeMap<String, String> treeMap = toSign();
        TreeMap<String, String> map = AESDecodeUtil.toTreeMap(treeMap);
        return map;
    }

    @Override
    public String toString() {
        return "QueryCommodityInfo{" +
                "goodsId='" + goodsId + '\'' +
                ", skuId='" + skuId + '\'' +
                ", appKey='" + appKey + '\'' +
                ", supplyChannel='" + supplyChannel + '\'' +
                ", channelId='" + channelId + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
