package com.hospital.hospitalserver.util;

import org.apache.commons.lang.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成特点随机数 工具类
 *
 */

public class RandomCodeUtils {
    /**
     * 封装方法：生成订单流水编号规则
     */
    public static String makeOrderCode(){
        //使用SimpleDateFormat设置一个时间显示格式
        SimpleDateFormat dmDate = new SimpleDateFormat("yyyyMMdd");
        //获取当前时间
        Date date = new Date();
        //使用刚设置好的时间格式对当前时间进行格式化
        String dateStr = dmDate.format(date);

        String randomCount = RandomStringUtils.randomNumeric(22);

        return dateStr+randomCount;
    }

    /**
     * 随机码，用于激活或其他应用
     * 该方法随机生成一个包含大小写字母和数字的字符串，一个参数表示该字符串包含的字母和数字的个数
     */
    public static String makeRandomCode(Integer count){
        String randomStr = RandomStringUtils.randomAlphanumeric(count);
        return randomStr;
    }
}