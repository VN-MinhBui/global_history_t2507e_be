package com.example.globalhistorybe.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleViewId implements Serializable {
    private Long articleId;
    private Long userId;
}
