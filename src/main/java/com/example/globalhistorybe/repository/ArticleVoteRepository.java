package com.example.globalhistorybe.repository;

import com.example.globalhistorybe.entity.ArticleVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleVoteRepository extends JpaRepository<ArticleVote, Long> {
}
