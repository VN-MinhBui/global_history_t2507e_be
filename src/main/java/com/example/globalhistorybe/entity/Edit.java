package com.example.globalhistorybe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "edits")
@Data
public class Edit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long editorId;

    private Long editableId; // id của article/event
    private String editableType; // "article" | "event"

    private String title;

    @Column(columnDefinition = "TEXT")
    private String summary;

    private String status;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private String thumbnail;

    private LocalDateTime createdAt;
    private LocalDateTime reviewedAt;

    private Long reviewedBy;

    private Integer upvoteCount;
    private Integer downvoteCount;
}
