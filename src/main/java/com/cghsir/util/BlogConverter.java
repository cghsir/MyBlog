package com.cghsir.util;

import com.cghsir.repository.domain.Blog;
import com.cghsir.web.vo.BlogVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 博客转换器
 * Created by cghsir on 2017/12/5.
 */
@Slf4j
public class BlogConverter extends ConvertS2T {

    /**
     * 转化成vo
     *
     * @param dao dao对象
     * @return
     */
    public static BlogVO convert2VO(Blog dao) {
        dao = ObjectUtils.isEmpty(dao) ? new Blog() : dao;
        BlogVO vo = new BlogVO();
        BeanUtils.copyProperties(dao, vo);
        log.info("【博客dao->vo】【博客vo:{}】【博客dao:{}】", vo, dao);
        return vo;
    }

    /**
     * 转化成dao
     *
     * @param vo
     * @param dao
     * @return
     */
    public static Blog convert2DAO(BlogVO vo, Blog dao) {
        vo = ObjectUtils.isEmpty(vo) ? new BlogVO() : vo;
        dao = ObjectUtils.isEmpty(dao) ? new Blog() : dao;
        BeanUtils.copyProperties(vo, dao);
        log.info("【博客vo->dao】【博客vo:{}】【博客dao:{}】", vo, dao);
        return dao;
    }

    /**
     * 转化成dao
     *
     * @param vo
     * @return
     */
    public static Blog convert2DAO(BlogVO vo) {
        return convert2DAO(vo, null);
    }

    /**
     * pageDao 转换 pageVo
     *
     * @param blogs
     * @param pageable
     * @return
     * @throws Exception
     */
    public static Page<BlogVO> convert2PagedBlogVO(Page<Blog> blogs, Pageable pageable) throws Exception {
        List<Blog> blogList = blogs.getContent();
        List<BlogVO> vos = convertListS2T(blogList, BlogVO.class);
        return new PageImpl<BlogVO>(vos, pageable, blogs.getTotalElements());
    }
}
