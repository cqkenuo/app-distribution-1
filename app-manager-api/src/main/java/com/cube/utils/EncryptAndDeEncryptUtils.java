package com.cube.utils;

import com.cube.common.exception.RRException;

import java.math.BigInteger;
import java.security.MessageDigest;

public class EncryptAndDeEncryptUtils {

    /**
     * 对字符串md5加密
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new RRException("MD5加密出现错误");
        }
    }

    public static void main(String[] args) {
        String admin = EncryptAndDeEncryptUtils.getMD5("deng123456");
        System.out.println(admin);
    }
}
