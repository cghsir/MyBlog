package com.cghsir.service;

import com.cghsir.web.vo.BlogVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by cghsir on 2017/12/5.
 */
public interface BlogService {

    /**
     * 保存博客
     *
     * @param blogvo
     */
    void save(BlogVO blogvo);

    /**
     * 查询一个博客
     *
     * @param id
     * @return
     */
    BlogVO findOne(String id);

    /**
     * 修改博客
     *
     * @param blogvo
     */
    void update(String id, BlogVO blogvo);

    /**
     * 删除博客
     *
     * @param id
     */
    void delete(String id);

    /**
     * 分页查询博客
     *
     * @param pageable
     * @return
     */
    Page<BlogVO> findAll(Pageable pageable) throws Exception;
}
