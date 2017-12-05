package com.cghsir.repository;


import com.cghsir.repository.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * blog dao
 * Created by cghsir on 2017/12/5.
 */
public interface BlogRepository extends JpaRepository<Blog, String> {

}
