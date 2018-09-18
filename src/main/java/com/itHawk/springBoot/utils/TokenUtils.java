package com.itHawk.springBoot.utils;

import java.util.UUID;

public class TokenUtils {
    /**
     * 随机生成UUID 作为用户信息的token
     * @return tonkrn
     */
    public static String createUserToken(){
        return UUID.randomUUID().toString();
    }
}
