package com.example.globalhistorybe.repository;

import com.example.globalhistorybe.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
