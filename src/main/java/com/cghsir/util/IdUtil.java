package com.cghsir.util;

import java.util.UUID;

/**
 * Created by cghsir on 2017/12/5.
 */
public class IdUtil {

    /**
     * 返回32位UUID
     * @return
     */
    public static String generator32(){
        return generator().replaceAll("-", "");
    }

    /**
     * 返回36位UUID
     * @return
     */
    public static String generator(){
        return UUID.randomUUID().toString();
    }


    public static void main(String[] args) {
        System.out.println(IdUtil.generator().length());
    }
}
