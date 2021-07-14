package com.projects.blog.Dtos;

import javax.persistence.*;

public class UpdateDto {

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;

    @Column(
            nullable = false,
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

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String comment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOldTitle() {
        return oldTitle;
    }

    public void setOldTitle(String title) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public UpdateDto(String title, String oldTitle, String description, String body, String author, String comment) {
        this.title = title;
        this.oldTitle = oldTitle;
        this.description = description;
        this.body = body;
        this.author = author;
        this.comment = comment;
    }

    public UpdateDto() {

    }
}
