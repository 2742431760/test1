package com.zoo9.seckill.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }
//    准备盐
    private static final String salt="1a2b3c4d";
    //第一次加密，这个发生在前端，暂时还不知道他想干什么
    public static String inputPassToFromPass(String inputPass){
        String str = salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }
    //第二次加密
    public static String formPassToDBPass(String formPass,String salt){
        String str = salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }
    public static String inputPassToDBPass(String inputPass,String salt){
        String formPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(formPass,salt);
        return dbPass;
    }
}
