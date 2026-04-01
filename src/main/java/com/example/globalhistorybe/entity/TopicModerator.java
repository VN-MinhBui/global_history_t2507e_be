package com.example.globalhistorybe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "topic_moderators")
@Data
@IdClass(TopicModeratorId.class)
public class TopicModerator {

    @Id
    private Long userId;

    @Id
    private Long topicId;

    private Long promotedBy;
    private LocalDateTime createdAt;
}
