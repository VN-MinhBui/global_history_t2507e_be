package com.example.globalhistorybe.repository;

import com.example.globalhistorybe.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("""
    SELECT a FROM Article a
    LEFT JOIN FETCH a.author
    WHERE (:keyword IS NULL OR LOWER(a.title) LIKE LOWER(CONCAT("%", :keyword, "%")))
    AND (:status IS NULL OR a.status = :status)
    """)
    Page<Article> search(String keyword, Article.Status status, Pageable pageable);
    boolean existsBySlug(String slug);
}
