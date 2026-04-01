package com.example.globalhistorybe.dto.req;

import lombok.Data;

import java.util.List;

@Data
public class ArticleRequest {

    private String title;

    private String content;
    private String thumbnail;
    private String summary;

    private List<String> countries;
}
