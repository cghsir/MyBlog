package com.cghsir.service.impl;

import com.cghsir.service.BlogService;
import com.cghsir.web.vo.BlogVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cghsir on 2017/12/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceImplTest {

    @Autowired
    private BlogService blogService;

    @Test
    public void save() throws Exception {
        BlogVO blogVO = new BlogVO();
        //blogVO.setId(IdUtil.generator32());
        blogVO.setTitle("vo标题");
        blogVO.setSummary("vo摘要");
        blogVO.setContent("vo内容");
        blogVO.setHtmlContent("vo——html内容");
        blogService.save(blogVO);
    }

    @Test
    public void update() throws Exception {
        BlogVO blogVO = blogService.findOne("6fa23fcf156a4d1b8e4cef7cd0af07ae");
        blogVO.setTitle("vo标题");
        blogVO.setSummary("vo摘要");
        blogVO.setContent("vo内容");
        blogVO.setHtmlContent("vo——html内容");
        blogService.update(blogVO.getId(), blogVO);
    }

    @Test
    public void delete() throws Exception {
        blogService.delete("6fa23fcf156a4d1b8e4cef7cd0af07ae");
    }

    @Test
    public void findAll() throws Exception {
        Pageable pageable = new PageRequest(0, 5);
        Page<BlogVO> all = blogService.findAll(pageable);
        System.out.println("Page<BlogVO>:" + all);
        Assert.assertNotEquals(0, all.getSize());

    }

    @Test
    public void findOne() {
        BlogVO one = blogService.findOne("6fa23fcf156a4d1b8e4cef7cd0af07ae");
        Assert.assertNotNull(one);
    }

}