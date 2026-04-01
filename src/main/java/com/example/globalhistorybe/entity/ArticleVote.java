package com.example.globalhistorybe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "article_votes")
@Data
@IdClass(ArticleVoteId.class)
public class ArticleVote {

    @Id
    private Long userId;

    @Id
    private Long articleId;

    private String voteType;
    private LocalDateTime createdAt;
}