package com.projects.blog.Blog;

import com.projects.blog.Dtos.UpdateDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Collection<Blog> getAllBlogs() {
        return blogRepository.findAllBlogs();
    }

    public Blog getBlogByTitle(String title) {
        return blogRepository.findBlogByTitle(title);
    }

    public void addNewBlog(String title, String description, String body, String author, MultipartFile image) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        Blog blog = new Blog(title, "", description, body, author);
        blog.setName(fileName);
        if(fileName.contains(".."))
        {
            System.out.println("not a valid file");
        }
        try {
            blog.setContent(Base64.getEncoder().encodeToString(image.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        blog.setSize(image.getSize());
        blog.setUploadTime(new Date());

        blogRepository.save(blog);
    }

    public void updateBlog(Blog blog){
        Blog foundBlog = blogRepository.findBlogByTitle(blog.getOldTitle());

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.map(blog, foundBlog);

        blogRepository.save(foundBlog);
    }

    public void deleteBlog(Blog blog) {
        blogRepository.deleteBlogByTitle(blog.getOldTitle());
    }
}
