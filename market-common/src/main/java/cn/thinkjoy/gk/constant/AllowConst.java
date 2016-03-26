package cn.thinkjoy.gk.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clei on 15/11/2.
 */
public class AllowConst {

    public static List<String> MAPPING_URLS = new ArrayList<String>();

    static{
        //上传相关
        MAPPING_URLS.add("http://127.0.0.1:8080/");
        MAPPING_URLS.add("http://localhost:8080/");
        MAPPING_URLS.add("http://sn.gaokao360.net/");
        MAPPING_URLS.add("http://gx.gaokao360.net/");
        MAPPING_URLS.add("http://sn.gk360.thinkjoy.com.cn");
        MAPPING_URLS.add("http://gx.gk360.thinkjoy.com.cn/");
        MAPPING_URLS.add("http://sn.thinkjoy.com:8080/");
        MAPPING_URLS.add("http://gx.thinkjoy.com:8080/");

        //支付相关
        MAPPING_URLS.add("http://orders.gk360.thinkjoy.com.cn/");
        MAPPING_URLS.add("http://orders.gaokao360.net/");
        MAPPING_URLS.add("http://pay.thinkjoy.cn/");
        MAPPING_URLS.add("http://test.pay.thinkjoy.cn/");
    }

}
