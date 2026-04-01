package com.example.globalhistorybe.controller;

import com.example.globalhistorybe.dto.req.ArticleRequest;
import com.example.globalhistorybe.dto.res.ArticleResponse;
import com.example.globalhistorybe.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/articles")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ArticleController {

    private final ArticleService service;

    @GetMapping
    public Page<ArticleResponse> getAll(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String status,
            Pageable pageable
    ){
        return service.getAll(keyword, status, pageable);
    }

    @PostMapping
    public ArticleResponse create(@RequestBody ArticleRequest article){
        return service.create(article);
    }

    @GetMapping("/{id}")
    public ArticleResponse getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ArticleResponse update(@PathVariable Long id,
                                  @RequestBody ArticleRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
