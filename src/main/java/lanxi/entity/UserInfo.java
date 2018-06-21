package lanxi.entity;

import java.math.BigDecimal;

/**
 * 订单的用户信息
 * Created by wuxiaobo on 2018/6/7 0007.
 */
public class UserInfo {
    //第三方账号
    private String accountId;
    //收货人姓名
    private String name;
    //手机号码
    private String mobile;
    //省份名称 如 浙江省
    private String provinceName;
    //城市名称 如 杭州市
    private String cityName;
    //县（区）名称 如 桐庐县 或者 滨江区
    private String districtName;
    //街道地址
    private String address;
    //实名信息
    private String identityId;
    //订单实付金额
    private BigDecimal realPrice;
    //邮费
    private BigDecimal expFee;
    //支付方式
    private String payMethod;

    public BigDecimal getExpFee() {
        return expFee;
    }

    public void setExpFee(BigDecimal expFee) {
        this.expFee = expFee;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", districtName='" + districtName + '\'' +
                ", address='" + address + '\'' +
                ", identityId='" + identityId + '\'' +
                ", realPrice=" + realPrice +
                ", expFee=" + expFee +
                ", payMethod='" + payMethod + '\'' +
                '}';
    }
}
