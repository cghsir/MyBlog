package com.cghsir.repository.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * blog 实体
 * Created by cghsir on 2017/12/5.
 */
@Entity
@Data
@DynamicUpdate
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 32)
    private String id;

    @NotEmpty(message = "标题不能为空")
    @Size(min = 2, max = 50)
    @Column(nullable = false)
    private String title;

    @NotEmpty(message = "摘要不能为空")
    @Size(min = 2, max = 300)
    @Column(nullable = false)
    private String summary;

    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Basic(fetch = FetchType.LAZY) // 懒加载
    @NotEmpty(message = "内容不能为空")
    @Size(min = 2)
    @Column(nullable = false)
    private String content;

    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Basic(fetch = FetchType.LAZY) // 懒加载
    @NotEmpty(message = "内容不能为空")
    @Size(min = 2)
    @Column(nullable = false)
    private String htmlContent;// 将 md 转为 html

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp createTime;

    @Column(nullable = false)
    @UpdateTimestamp
    private Timestamp updateTime;

    public Blog() {
    }
}