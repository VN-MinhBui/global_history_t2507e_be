package com.example.globalhistorybe.controller;

import com.example.globalhistorybe.entity.Topic;
import com.example.globalhistorybe.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class PublicTopicController {

    private final TopicRepository topicRepository;

    @GetMapping
    public ResponseEntity<List<Topic>> getAll() {
        return ResponseEntity.ok(topicRepository.findAll());
    }
}
