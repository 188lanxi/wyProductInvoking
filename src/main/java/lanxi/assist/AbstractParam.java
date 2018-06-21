package lanxi.assist;

import com.lanxi.util.AESDecodeUtil;
import com.lanxi.util.SignUtil;

import java.util.TreeMap;

/**
 * 抽象参数类
 * Created by wuxiaobo on 2018/6/15 0015.
 */
public abstract class AbstractParam implements ToTreeMap,ToEncryptTreeMap,ToSign{
    //平台分发的appKey
    protected String appKey;
    //平台分发的channelId
    protected String channelId;
    //签名
    protected String sign;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public TreeMap<String,String> toSign() {
        TreeMap<String, String> treeMap = toTreeMap();
        String sign = SignUtil.toSign(treeMap);
        treeMap.put("sign",sign);
        return treeMap;
    }

    @Override
    public TreeMap<String, String> toTreeMap() {
        TreeMap<String,String> treeMap=new TreeMap<>();
        treeMap.put("appKey",appKey);
        treeMap.put("channelId",channelId);
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
        return "AbstractParam{" +
                "appKey='" + appKey + '\'' +
                ", channelId='" + channelId + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
