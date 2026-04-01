package com.example.globalhistorybe.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class EditVoteId implements Serializable {
    private Long userId;
    private Long editId;
}
