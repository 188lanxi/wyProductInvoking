package lanxi.util;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * 生成签名工具类
 * Created by wuxiaobo on 2018/6/6 0006.
 */
public class SignUtil {
    /**
     * 生成小写签名
     * @param map
     * @return
     */
    public static String toSign(TreeMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (!next.equals("sign")){
                sb.append(next).
                        append("=").
                        append(map.get(next));
            }
        }
        String waitSign = sb.toString();
        //MD5加密
        String sign = MD5Util.parseStrToMd5L32(waitSign);
        return sign;
    }
}
