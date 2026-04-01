package com.example.globalhistorybe.dto.res;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ArticleResponse {

    private Long id;
    private String title;
    private String slug;
    private String description;
    private String content;

    private String author;
    private String category;
    private String country;
    private String image;
    private Integer comments;
    private List<SectionDTO> sections;

    private Integer views;
    private Integer likes;
    private Integer dislikes;

    private String publishDate;
    private String lastUpdated;

    private String status;
    private LocalDateTime createdAt;
}
