package com.cghsir.web.controller;

import com.cghsir.service.BlogService;
import com.cghsir.web.vo.BlogVO;
import com.cghsir.web.vo.ResultVO;
import com.cghsir.web.vo.ResultVOFacotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * blog控制器
 * Created by cghsir on 2017/12/5.
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 查询一个博客信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id:[A-z0-9]{32}}")
    public ResultVO<BlogVO> findOne(@PathVariable(value = "id") String id) {
        return ResultVOFacotry.success(blogService.findOne(id));
    }

    /**
     * 保存一个博客
     *
     * @param blogVO
     * @return
     */
    @PostMapping
    public ResultVO saveBlog(@RequestBody BlogVO blogVO) {
        blogService.save(blogVO);
        return ResultVOFacotry.success();
    }

    /**
     * 修改一个博客
     *
     * @param id
     * @param blogVO
     * @return
     */
    @PutMapping("/{id:[A-z0-9]{32}}")
    public ResultVO updateBlog(@PathVariable("id") String id, @RequestBody BlogVO blogVO) {
        blogVO.setId(id);
        blogService.update(id, blogVO);
        return ResultVOFacotry.success();
    }

    /**
     * 删除一个博客
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id:[A-z0-9]{32}}")
    public ResultVO deleteBlog(@PathVariable("id") String id) {
        blogService.delete(id);
        return ResultVOFacotry.success();
    }

    @GetMapping
    public ResultVO<List<BlogVO>> findAll(@PageableDefault() Pageable pageable) throws Exception {
        Page<BlogVO> all = blogService.findAll(pageable);
        return ResultVOFacotry.success(all);
    }

}
