package com.example.globalhistorybe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "edits_votes")
@Data
@IdClass(EditVoteId.class)
public class EditVote {

    @Id
    private Long userId;

    @Id
    private Long editId;

    private String voteType;
    private LocalDateTime createdAt;
}
