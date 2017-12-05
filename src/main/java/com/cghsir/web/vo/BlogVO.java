package com.cghsir.web.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by cghsir on 2017/12/5.
 */
@Data
public class BlogVO {

    private String id;

    private String title;

    private String summary;

    private String content;

    private String htmlContent;// 将 md 转为 html

    private Timestamp createTime;

    private Timestamp updateTime;

    public BlogVO() {
    }
}
