package com.projects.blog.profile;

import javax.persistence.*;

@Table
@Entity(name = "UserProfile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String username;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;


    public UserProfile(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserProfile(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
