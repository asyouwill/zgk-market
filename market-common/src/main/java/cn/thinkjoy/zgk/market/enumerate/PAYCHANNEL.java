package cn.thinkjoy.zgk.market.enumerate;

/**
 * Created by wpliu on 16/3/30.
 */
public enum PAYCHANNEL {
    //支付宝手机支付
    ALIPAY("alipay"),
    //支付宝手机网页支付
    ALIPAYWAP("alipay_wap"),
    //支付宝PC网页支付
    ALIPAYPC("alipay_pc_direct"),
    //支付宝扫码支付
    ALIPAYQR("alipay_qr"),
    //百度钱包移动快捷支付
    BFB("bfb"),
    //百度钱包手机网页支付
    BFBWAP("bfb_wap"),
    //银联全渠道支付
    UPACP("upacp"),
    //银联全渠道手机网页支付
    UPACPWAP("upacp_wap"),
    //银联 PC 网页支付
    UPACPPC("upacp_pc"),
    //银联企业网银支付
    CPB2B("cp_b2b"),
    //微信支付
    WX("wx"),
    //微信公众账号支付
    WXPUB("wx_pub"),
    //微信公众账号扫码支付
    WXPUNQR("wx_pub_qr"),
    //易宝手机网页支付
    YEEPAYAP("yeepay_wap"),
    //京东手机网页支付
    JDPAYWAP("jdpay_wap"),
    //应用内快捷支付（银联）
    CNPU("cnp_u"),
    //应用内快捷支付（外卡）
    CNPF("应用内快捷支付（外卡）"),
    //Apple Pay
    APPLEPAYUPACP("Apple Pay");

    private String payChannel;
     PAYCHANNEL(String paychannel){

        this.payChannel=paychannel;
    }

    public String getCode(){
        return this.payChannel;
    }
}
