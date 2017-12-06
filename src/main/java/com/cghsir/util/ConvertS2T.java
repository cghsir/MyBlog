package com.cghsir.util;

import com.cghsir.repository.domain.Blog;
import com.cghsir.web.vo.BlogVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cghsir on 2017/12/5.
 */
public class ConvertS2T {

    /**
     * List 泛型转换
     *
     * @param sourceList 源数据
     * @param clazz      要转换的目标类型
     * @param <S>        类型一
     * @param <T>        类型二
     * @return
     * @throws Exception
     */
    public static <S, T> List<T> convertListS2T(List<S> sourceList, Class<T> clazz) throws Exception {
        // 返回目标类型的结果
        List<T> rtn = new ArrayList<T>();
        try {
            if (sourceList != null) {
                for (S source : sourceList) {
                    T target = clazz.newInstance();
                    MyBeanUtils.copyPropertiesIgnoreNull(source, target);
                    rtn.add(target);
                }
            }
        } catch (Exception e) {
            throw new Exception("对象转换异常！");
        }
        return rtn;
    }

    public static void main(String[] args) throws Exception {
        List<Blog> blogs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Blog blog = new Blog();
            blog.setId(IdUtil.generator32());
            blog.setTitle("测试标题");
            blogs.add(blog);
        }
        System.out.println("转化前：" + blogs);
        List<BlogVO> blogVOS = convertListS2T(blogs, BlogVO.class);
        System.out.println("转化后" + blogVOS);

    }
}
