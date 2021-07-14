package com.projects.blog.Blog;

import com.projects.blog.Dtos.UpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("api/v1/blog")
@CrossOrigin(origins = "*")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    private DocumentRepository repo;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping(value = "/getblogs")
    public Collection<Blog> getBlogs() {
        return blogService.getAllBlogs();
    }

    @PostMapping(value = "/createblog",produces = {MediaType.IMAGE_PNG_VALUE, "application/json"})
    public void registerBlog(@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("body") String body, @RequestParam("author") String author, @RequestParam("image") MultipartFile image) throws IOException {
        blogService.addNewBlog(title, description, body, author, image);
    }

    @PostMapping(value = "/updateblog", consumes = "application/json", produces = "application/json")
    public void updateBlog(@RequestBody Blog blog) {
        blogService.updateBlog(blog);
    }

    @PostMapping(value = "/deleteblog", consumes = "application/json", produces = "application/json")
    public void deleteBlog(@RequestBody Blog blog) {
        blogService.deleteBlog(blog);
    }

    @PostMapping(value = "/blogbytitle", consumes = "application/json", produces = "application/json")
    public void getBlogByTitle(@RequestParam("title") String title) {
        blogService.getBlogByTitle(title);
    }

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("document") MultipartFile multipartFile, RedirectAttributes ra) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        Document document = new Document();
        document.setName(fileName);
        document.setContent(multipartFile.getBytes());
        document.setSize(multipartFile.getSize());
        document.setUploadTime(new Date());

        repo.save(document);
    }

}