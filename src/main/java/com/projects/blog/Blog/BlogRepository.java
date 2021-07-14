package com.projects.blog.Blog;

import com.projects.blog.Blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "SELECT * from blog", nativeQuery = true)
    Collection<Blog> findAllBlogs();

    @Query(value = "SELECT * from blog WHERE title = :title", nativeQuery = true)
    Blog findBlogByTitle(@Param("title") String title);

    @Transactional
    @Modifying
    @Query(value = "DELETE from blog WHERE title = :title", nativeQuery = true)
    void deleteBlogByTitle(@Param("title") String title);
}
