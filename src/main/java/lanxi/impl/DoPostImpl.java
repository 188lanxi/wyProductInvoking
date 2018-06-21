package lanxi.impl;

import com.lanxi.assist.DoPost;
import com.lanxi.entity.*;
import com.lanxi.util.ProperrtiesUtil;
import org.apache.log4j.Logger;

/**
 * Created by wuxiaobo on 2018/6/15 0015.
 */
public class DoPostImpl {
    private static Logger log=Logger.getLogger(DoPostImpl.class);
    private static String url="http://192.168.17.84:8083/wyproduct";

    /**
     * 查询所有
     * @return
     */
    public static String queryAllGoodsIdAndSkuId(){
        String result=null;
        try {
            QueryAllGoodsIdAndSkuIdParam param=new QueryAllGoodsIdAndSkuIdParam();
            String appKey = ProperrtiesUtil.get("appKey");
            String channelId = ProperrtiesUtil.get("channelId");
            param.setAppKey(appKey);
            param.setChannelId(channelId);
            String path=ProperrtiesUtil.get("queryAllGoodsIdAndSkuIdPath");
            result = DoPost.request(url + path, param.toEncryptTreeMap(), "utf-8");
        }catch (Exception e){
            log.error("查询所有商品GoodsId和SkuId时发生异常",e);
            return result;
        }
        return result;
    }

    /**
     * 查询商品详情
     * @param goodsId
     * @param skuId
     * @param supplyChannel
     * @return
     */
    public static  String queryCommmodityInfoById(String goodsId,String skuId,String supplyChannel){
        String result=null;
        try {
            QueryCommodityInfo param=new QueryCommodityInfo();
            String appKey = ProperrtiesUtil.get("appKey");
            String channelId = ProperrtiesUtil.get("channelId");
            param.setAppKey(appKey);
            param.setChannelId(channelId);
            param.setGoodsId(goodsId);
            param.setSkuId(skuId);
            param.setSupplyChannel(supplyChannel);
            System.err.println("param"+param);
            String path=ProperrtiesUtil.get("queryCommodityInfoByIdPath");
            result = DoPost.request(url + path, param.toEncryptTreeMap(), "utf-8");
        }catch (Exception e){
            log.error("查询商品详情时发生异常",e);
            return result;
        }
        return result;
    }

    /**
     * 下单
     * @param param
     * @return
     */
    public static String bookOrder(BookOrderParam param){
        String result=null;
        try {
            String appKey = ProperrtiesUtil.get("appKey");
            String channelId = ProperrtiesUtil.get("channelId");
            param.setAppKey(appKey);
            param.setChannelId(channelId);
            String path=ProperrtiesUtil.get("bookOrderPath");
            result = DoPost.request(url + path, param.toEncryptTreeMap(), "utf-8");
        }catch (Exception e){
            log.error("下单时发生异常",e);
            return result;
        }
        return result;
    }

    /**
     * 订单物流查询
     * @param orderId
     * @param supplyChannel
     * @return
     */
    public static String logisticsQuery(String orderId,String supplyChannel){
        String result=null;
        try {
            String appKey = ProperrtiesUtil.get("appKey");
            String channelId = ProperrtiesUtil.get("channelId");
            LogisticsQueryParam param=new LogisticsQueryParam();
            param.setOrderId(orderId);
            param.setSupplyChannel(supplyChannel);
            param.setAppKey(appKey);
            param.setChannelId(channelId);
            String path=ProperrtiesUtil.get("logisticsQueryPath");
            result = DoPost.request(url + path, param.toEncryptTreeMap(), "utf-8");
        }catch (Exception e){
            log.error("物流查询时发生异常",e);
            return result;
        }
        return result;
    }

    /**
     * 订单状态查询
     * @param orderId
     * @param supplyChannel
     * @return
     */
    public static String orderStatusQuery(String orderId,String supplyChannel){
        String result=null;
        try {
            String appKey = ProperrtiesUtil.get("appKey");
            String channelId = ProperrtiesUtil.get("channelId");
            OrderStatusQueryParam param=new OrderStatusQueryParam();
            param.setAppKey(appKey);
            param.setChannelId(channelId);
            param.setOrderId(orderId);
            param.setSupplyChannel(supplyChannel);
            String path=ProperrtiesUtil.get("orderStatusQueryParamPath");
            result = DoPost.request(url + path, param.toEncryptTreeMap(), "utf-8");
        }catch (Exception e){
            log.error("查询订单状态时发生异常",e);
            return result;
        }
            return result;
    }
    public static void main(String[] args) {
//        String queryAllGoodsIdAndSkuId = queryAllGoodsIdAndSkuId();
//        System.err.println(queryAllGoodsIdAndSkuId);
        String queryCommmodityInfoById = queryCommmodityInfoById("1040000", "1042001", "10002");
        System.err.println(queryCommmodityInfoById);
//        BookOrderParam param=new BookOrderParam();
//        param.setOrderId("2018062004");
//        param.setSupplyChannel("10002");
//        UserInfo userInfo=new UserInfo();
//        userInfo.setAccountId("123@163.com");
//        userInfo.setName("吴晓波");
//        userInfo.setMobile("18838427407");
//        userInfo.setProvinceName("浙江省");
//        userInfo.setCityName("杭州市");
//        userInfo.setDistrictName("滨江区");
//        userInfo.setAddress("月明路685号正泰大厦15楼");
//        userInfo.setIdentityId("411122199401048091");
//        userInfo.setRealPrice(new BigDecimal("51"));
//        userInfo.setExpFee(new BigDecimal("0"));
//        userInfo.setPayMethod("现金支付");
//        param.setUserInfo(userInfo);
//        OrderItem orderItem=new OrderItem();
//        orderItem.setGoodsId("1040000");
//        orderItem.setSkuId("1042001");
//        orderItem.setBuyAmount(1);
//        orderItem.setChannelSalePrice(new BigDecimal("40"));
//        orderItem.setProductName("openapi专用勿改1042000");
//        orderItem.setSubtotalAmount(new BigDecimal("40"));
//        OrderItem orderItem2=new OrderItem();
//        orderItem2.setGoodsId("1083000");
//        orderItem2.setSkuId("1082001");
//        orderItem2.setBuyAmount(1);
//        orderItem2.setChannelSalePrice(new BigDecimal("11"));
//        orderItem2.setProductName("openapi专用勿改1085000");
//        orderItem2.setSubtotalAmount(new BigDecimal("11"));
//        OrderItem orderItem3=new OrderItem();
//        orderItem3.setGoodsId("58726200");
//        orderItem3.setSkuId("58726200-ecc4090b639c47f89b453980923afb8e");
//        orderItem3.setBuyAmount(1);
//        orderItem3.setChannelSalePrice(new BigDecimal("599"));
//        orderItem3.setProductName("openapi专用勿改1085000");
//        orderItem3.setSubtotalAmount(new BigDecimal("599"));
//        List<OrderItem> list=new ArrayList<>();
//        //list.add(orderItem);
//        list.add(orderItem2);
//        //list.add(orderItem3);
//        param.setOrderItemList(list);
//        String bookOrder = bookOrder(param);
//        System.err.println(bookOrder);
//        String logisticsQuery = logisticsQuery("2018062004","10002");
//        System.err.println(logisticsQuery);
//        String orderStatusQuery = orderStatusQuery("20180619", "10001");
//        System.err.println(orderStatusQuery);
    }
}
