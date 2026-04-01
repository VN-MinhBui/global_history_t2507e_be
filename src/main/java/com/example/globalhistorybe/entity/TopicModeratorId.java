package com.example.globalhistorybe.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TopicModeratorId implements Serializable {
    private Long userId;
    private Long topicId;
}
