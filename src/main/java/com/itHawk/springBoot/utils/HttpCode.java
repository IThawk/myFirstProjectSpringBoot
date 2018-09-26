package com.itHawk.springBoot.utils;

public  class   HttpCode {
    //请求成功
    public static final int RESPONSE_SUCCESS=0;
    //请求失败
    public static final int RESPONSE_ERROR=-1;
    //用户已经存在
    public static final int USER_IS_EXIT=1001;
    //用户已经存在
    public static final int USER_PASSWORD_IS_ERROR=1002;
    //用户旧密码输入此次过多
    public static final int USER_OLDPASSWORD_IS_ERROR_TOO_TIMES=1003;
}
