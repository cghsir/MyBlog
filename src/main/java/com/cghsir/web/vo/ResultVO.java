package com.cghsir.web.vo;

import lombok.Data;

/**
 * http请求的最终对象
 * Created by cghsir on 2017/12/5.
 */
@Data
public class ResultVO<T> {

    /**
     * 消息码.
     */
    private Integer code;
    /**
     * 消息.
     */
    private String message;
    /**
     * 数据.
     */
    private T object;

    protected ResultVO(Integer code, String message, T object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public ResultVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVO() {
    }
}
