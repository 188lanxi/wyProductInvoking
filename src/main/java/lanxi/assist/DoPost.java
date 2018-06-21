package lanxi.assist;

import com.alibaba.fastjson.JSON;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by wuxiaobo on 2018/6/15 0015.
 */
public interface DoPost {
    static String request(String url, TreeMap<String, String> data, String charset) throws IOException {
        HttpPost post=new HttpPost(url);
        //组装参数
        System.err.println("url:"+url);
        List<NameValuePair> params=new ArrayList<>();
        data.entrySet().stream().forEach(e ->params.add(new BasicNameValuePair(e.getKey(),e.getValue())));
        System.err.println("param"+ JSON.toJSONString(params));
        post.setEntity(new UrlEncodedFormEntity(params,charset));
        CloseableHttpClient httpclient   = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = httpclient.execute(post);
        BufferedReader buffReader   = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), charset));
        StringBuffer          strBuff      = new StringBuffer();
        String                temp         = null;
        while ((temp = buffReader.readLine()) != null) {
            strBuff.append(temp);
        }
        return strBuff.toString();
    }
}
