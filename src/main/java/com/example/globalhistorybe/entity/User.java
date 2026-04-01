package com.example.globalhistorybe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @Column(name = "is_admin")
    private  Boolean isAdmin;

    private  String avatar;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private Integer viewCount;
    private Integer likeCount;
    private Integer dislikeCount;

    private LocalDateTime createdAt;
}