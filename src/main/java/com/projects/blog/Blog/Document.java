package com.projects.blog.Blog;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 512, nullable = false, unique = true)
    private String name;

    private long size;

    @Column(name = "upload_time")
    private Date uploadTime;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(length=1048576)
    private byte[] content;

    public Document() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getSize() { return size; }

    public void setSize(Long size) { this.size = size; }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte[] getContent() {
        return content;
    }

    public void setUploadTime(Date uploadTime){
        this.uploadTime = uploadTime;
    }

    public Date getUploadTime(){
        return uploadTime;
    }
}
