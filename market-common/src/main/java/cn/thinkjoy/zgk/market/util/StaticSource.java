package cn.thinkjoy.zgk.market.util;

import cn.thinkjoy.cloudstack.dynconfig.DynConfigClientFactory;

public class StaticSource {
    public  static String getSource(String sourceName){

        String source="";
        try {
            source= DynConfigClientFactory.getClient().getConfig("common", sourceName);
        }catch (Exception e){
            return  source;
        }
            return source;
    }

}