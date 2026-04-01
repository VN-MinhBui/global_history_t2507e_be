package com.example.globalhistorybe.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "media")
@Data
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String url;

    private Long mediaableId;
    private String mediaableType;
}
