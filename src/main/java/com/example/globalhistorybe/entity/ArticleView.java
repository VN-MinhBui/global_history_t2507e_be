package com.example.globalhistorybe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "article_views")
@Data
@IdClass(ArticleViewId.class)
public class ArticleView {

    @Id
    private Long articleId;

    @Id
    private Long userId;

    private LocalDateTime viewedAt;
}
