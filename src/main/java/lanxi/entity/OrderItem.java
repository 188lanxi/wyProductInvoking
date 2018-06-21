package lanxi.entity;

import java.math.BigDecimal;

/**
 * 订单商品信息
 * Created by wuxiaobo on 2018/6/7 0007.
 */
public class OrderItem {
    //商品goodsId
    private String goodsId;
    //商品skuId
    private String skuId;
    //购买数量
    private Integer buyAmount;
    //价格
    private BigDecimal channelSalePrice;
    //商品名称
    private String productName;
    //金额小计
    private BigDecimal subtotalAmount;

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

    public Integer getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(Integer buyAmount) {
        this.buyAmount = buyAmount;
    }

    public BigDecimal getChannelSalePrice() {
        return channelSalePrice;
    }

    public void setChannelSalePrice(BigDecimal channelSalePrice) {
        this.channelSalePrice = channelSalePrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getSubtotalAmount() {
        return subtotalAmount;
    }

    public void setSubtotalAmount(BigDecimal subtotalAmount) {
        this.subtotalAmount = subtotalAmount;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "goodsId='" + goodsId + '\'' +
                ", skuId='" + skuId + '\'' +
                ", buyAmount=" + buyAmount +
                ", channelSalePrice=" + channelSalePrice +
                ", productName='" + productName + '\'' +
                ", subtotalAmount=" + subtotalAmount +
                '}';
    }
}
