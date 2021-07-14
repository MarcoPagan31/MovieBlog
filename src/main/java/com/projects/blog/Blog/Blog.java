package com.projects.blog.Blog;

import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Table
@Entity(name = "Blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;

    @Column(
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String oldTitle;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Lob
    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String body;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String author;

    public Long getId() { return id; }

    public String getOldTitle() {
        return oldTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column()
    private String name;

    @Column()
    private long size;

    @Column(name = "upload_time")
    private Date uploadTime;

    @Column()
    private String content;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getSize() { return size; }

    public void setSize(Long size) { this.size = size; }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setUploadTime(Date uploadTime){
        this.uploadTime = uploadTime;
    }

    public Date getUploadTime(){
        return uploadTime;
    }

    public Blog(String title, String oldTitle, String description, String body, String author) {
        this.title = title;
        this.oldTitle = oldTitle;
        this.description = description;
        this.body = body;
        this.author = author;
    }

    public Blog() {

    }

}
