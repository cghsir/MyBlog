package com.cghsir.web.vo;

/**
 * Created by cghsir on 2017/12/5.
 */
public class ResultVOFacotry {

    public static ResultVO success(Object object) {
        return new ResultVO(200, "操作成功", object);
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        return new ResultVO(code, msg);
    }

}
