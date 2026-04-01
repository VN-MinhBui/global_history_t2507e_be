package com.example.globalhistorybe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "historical_events")
@Data
public class HistoricalEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creator_id")
    private Long creatorId;

    private String title;
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String summary;

    private Integer eventYear;
    private LocalDate eventDate;

    private LocalDateTime createdAt;
    private LocalDateTime reviewedAt;

    private Long reviewedBy;
    private Long currentEditId;
}