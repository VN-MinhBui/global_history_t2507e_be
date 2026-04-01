package com.example.globalhistorybe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "articles")
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String slug;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private String country;
    @ManyToMany
    @JoinTable(
            name = "article_topics",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    private List<Topic> topics;

    private String thumbnail;
    private Long currentEditId;

    private Integer viewCount = 0;
    private Integer likeCount = 0;
    private Integer dislikeCount = 0;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum Status {
        draft, pending, published, rejected
    }
}
