package cn.thinkjoy.zgk.market.util;

/**
 * Created by wpliu on 16/3/27.
 */

import java.util.UUID;

/**
 * 流水号，订单号生成工具类
 */
public class NumberGenUtil {

    /**
     * 生成流水号 8-20位
     * @return
     */
    public static String genStatementNo(){
            UUID  uuid=UUID.randomUUID();
        String uuidStr=uuid.toString();
        return uuidStr.substring(20);
    }


    /**
     * 生成订单号 1-32位
     */
    public static String genOrderNo(){
        UUID uuid= UUID.randomUUID();
        String uuidStr=uuid.toString();
        return uuidStr.substring(0, 8) + uuidStr.substring(9, 13) + uuidStr.substring(14, 18) + uuidStr.substring(19, 23) + uuidStr.substring(24);
    }

    public static void main(String[] args){
       System.out.println(NumberGenUtil.genStatementNo());

    }
}
