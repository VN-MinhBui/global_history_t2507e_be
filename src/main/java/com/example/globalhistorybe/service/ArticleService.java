package com.example.globalhistorybe.service;

import com.example.globalhistorybe.dto.req.ArticleRequest;
import com.example.globalhistorybe.dto.res.ArticleResponse;
import com.example.globalhistorybe.dto.res.SectionDTO;
import com.example.globalhistorybe.entity.Article;
import com.example.globalhistorybe.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository repo;


    public ArticleResponse create(ArticleRequest article){
        Article article1 = new Article();
        article1.setTitle(article.getTitle());
        article1.setContent(article.getContent());
        article1.setSummary(article.getSummary());
        article1.setThumbnail(article.getThumbnail());
        article1.setSlug(generateUniqueSlug(article.getTitle()));

        Article saved  = repo.save(article1);
        return toResponse(saved);
    }

    public Page<ArticleResponse> getAll(String keyword, String status, Pageable pageable){
        Article.Status enumStatus = null;

        try {
            if (status != null){
                enumStatus = Article.Status.valueOf(status);
            }
        } catch (IllegalArgumentException e) {
            enumStatus = null;
        }
        Page<Article> page = repo.search(keyword, enumStatus, pageable);
        return page.map(this::toResponse);
    }

    private ArticleResponse toResponse(Article article){
        String categoryName = (article.getTopics() != null && !article.getTopics().isEmpty())
                ? article.getTopics().get(0).getName()
                : "Uncategorized";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .slug(article.getSlug())
                .category(categoryName)
                .description(article.getSummary())
                .content(article.getContent())
                .image(article.getThumbnail())
                .views(article.getViewCount())
                .likes(article.getLikeCount())
                .dislikes(article.getDislikeCount())
                .status(article.getStatus() != null ? article.getStatus().name() : null)
                .createdAt(article.getCreatedAt())
                .author(article.getAuthor() != null ? article.getAuthor().getUsername() : "Anonymous")
                .country(article.getCountry() != null ? article.getCountry() : "Unknown")
                .publishDate(article.getCreatedAt() != null ? article.getCreatedAt().format(formatter) : null)
                .lastUpdated(article.getUpdatedAt() != null ? article.getUpdatedAt().format(formatter) : null)
                .sections(extractSections(article.getContent()))
                .comments(156)
                .build();
    }

    private List<SectionDTO> extractSections(String content) {
        List<SectionDTO> sections = new ArrayList<>();
        if (content == null || content.isEmpty()) return sections;

        String[] lines = content.split("\\R");
        for (String line : lines) {
            if (line.trim().startsWith("## ")) {
                String title = line.substring(3).trim();
                String id = title.toLowerCase()
                        .replaceAll("\\(.*?\\)", "")
                        .replaceAll("[^a-z0-9\\s]", "")
                        .trim()
                        .replaceAll("\\s+", "-");
                sections.add(new SectionDTO(title, id));
            }
        }
        return sections;
    }

    public ArticleResponse update(Long id, ArticleRequest request) {
        Article article = repo.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));

        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
        article.setSummary(request.getSummary());
        article.setThumbnail(request.getThumbnail());

        Article updated = repo.save(article);
        return toResponse(updated);
    }

    public ArticleResponse getById(Long id) {
        Article article = repo.findById(id).orElseThrow(() -> new RuntimeException("Article Not Found"));
        return toResponse(article);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Article Not Found");
        }
        repo.deleteById(id);
    }

    private String toSlug(String title) {
        return title.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "")
                .replaceAll("\\s+", "-")
                .trim();
    }

    private String generateUniqueSlug(String title) {
        String baseSlug = toSlug(title);
        String slug = baseSlug;
        int count = 1;

        while (repo.existsBySlug(slug)) {
            slug = baseSlug + "-" + count;
            count++;
        }

        return slug;
    }
}
