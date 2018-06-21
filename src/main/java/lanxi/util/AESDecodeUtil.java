package lanxi.util;

import java.util.Map;
import java.util.TreeMap;

/**
 * 解密参数
 * Created by wuxiaobo on 2018/6/8 0008.
 */
public class AESDecodeUtil {

    public static TreeMap<String, String> toTreeMap(Map<String, String> map) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            switch (entry.getKey()) {
                case "appKey":
                    treeMap.put(entry.getKey(), entry.getValue());
                    break;
                case "channelId":
                    treeMap.put(entry.getKey(), entry.getValue());
                    break;
                case "sign":
                    treeMap.put(entry.getKey(),entry.getValue());
                    break;
                default:
                    String key = AESCoder.aesEncrypt(entry.getKey());
                    String value = AESCoder.aesEncrypt(entry.getValue());
                    treeMap.put(key,value);
                    break;
            }
        }
        return treeMap;
    }
}