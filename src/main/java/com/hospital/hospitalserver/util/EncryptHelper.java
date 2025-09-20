package com.hospital.hospitalserver.util;

import java.security.MessageDigest;


/**
 * @author 李耀华
 * @since 2023年5月29日
 * 字符串加密工具类
 */

public class EncryptHelper {
    private static final String KEY_SHA = "SHA"; //SHA-1算法
    private static final String KEY_SHA256 = "SHA-256"; //SHA-256算法
    private static final String KEY_SHA512 = "SHA-512"; //SHA-512算法
    private static final String KEY_MD5 = "MD5";


    /**
     * SHA算法
     *
     * @param data
     * @return
     */
    public static String SHA(String data) {
        try {
            // 判断数据的合法性
            if (data == null) {
                throw new RuntimeException("数据不能为NULL");
            }
            // 获取SHA算法的类型
            MessageDigest sha = MessageDigest.getInstance(KEY_SHA512);
            // 加入数据
            sha.update(data.getBytes());
            // 获取消息摘要
            byte[] resultBytes = sha.digest();
            // 将字节数组转换为16进制
            String resultString = fromBytesToHex(resultBytes);
            // 返回
            return resultString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 将字节数组转化为16进制
     *
     * @param resultBytes
     * @return
     */
    private static String fromBytesToHex(byte[] resultBytes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < resultBytes.length; i++) {
            if (Integer.toHexString(0xFF & resultBytes[i]).length() == 1) {
                builder.append("0").append(
                        Integer.toHexString(0xFF & resultBytes[i]));
            } else {
                builder.append(Integer.toHexString(0xFF & resultBytes[i]));
            }
        }
        return builder.toString();
    }
}
