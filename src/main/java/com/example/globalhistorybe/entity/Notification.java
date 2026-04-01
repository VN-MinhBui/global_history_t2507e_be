package com.example.globalhistorybe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK -> users
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // loại notification (string theo DB của mày)
    @Column(nullable = false)
    private String type;

    // nội dung
    @Column(columnDefinition = "TEXT")
    private String content;

    // đã đọc chưa
    @Column(name = "is_read")
    private Boolean isRead = false;

    // id liên quan (article, comment, edit...)
    @Column(name = "reference_id")
    private Long referenceId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}