package com.cghsir.service.impl;

import com.cghsir.repository.BlogRepository;
import com.cghsir.repository.domain.Blog;
import com.cghsir.service.BlogService;
import com.cghsir.util.BlogConverter;
import com.cghsir.util.IdUtil;
import com.cghsir.web.vo.BlogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by cghsir on 2017/12/5.
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository repository;

    @Override
    public void save(BlogVO blogvo) {
        Blog blog = BlogConverter.convert2DAO(blogvo);
        blog.setId(IdUtil.generator32());
        repository.save(blog);
    }

    @Override
    public BlogVO findOne(String id) {
        return BlogConverter.convert2VO(repository.findOne(id));
    }

    @Override
    public void update(BlogVO blogvo) {
        repository.save(BlogConverter.convert2DAO(blogvo));
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public Page<BlogVO> findAll(Pageable pageable) throws Exception {
        Page<Blog> all = repository.findAll(pageable);
        System.out.println("Page<Blog>:" + all);
        return BlogConverter.convert2PagedBlogVO(all, pageable);
    }

}
