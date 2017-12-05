package com.cghsir.repository;

import com.cghsir.repository.domain.Blog;
import com.cghsir.util.IdUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by cghsir on 2017/12/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {

    @Autowired
    private BlogRepository repository;

    @Test
    public void testSaveOne() {
        Blog blog = new Blog();
        blog.setId(IdUtil.generator32());
        blog.setTitle("这是一个测试标题" + IdUtil.generator());
        blog.setSummary("这是一个测试摘要" + IdUtil.generator());
        blog.setContent("这是一个测试内容" + IdUtil.generator());
        blog.setHtmlContent("这是一个html测试内容" + IdUtil.generator());
        Blog save = repository.save(blog);
        Assert.assertNotNull(save);
        System.out.println(save.toString());
    }

    @Test
    public void testUpdateOne() {
        Blog one = repository.findOne("584e68028dbe4131abe0ed41de935da1");
        one.setTitle("这是修改方法更改的标题123");
        Blog save = repository.save(one);
        Assert.assertNotNull(save);
        System.out.println(save.toString());
    }

    @Test
    public void testDeleteOne() {
        repository.delete("584e68028dbe4131abe0ed41de935da1");
    }

    @Test
    public void testFindAll() {
        List<Blog> all = repository.findAll();
        Assert.assertNotEquals(0, all.size());
        System.out.println(all);
    }

}