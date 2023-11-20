package com.anilgubbala.controller;

import com.anilgubbala.payload.PostDto;
import com.anilgubbala.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    private PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Create Blog post
     * @param postDto
     * @return
     */
    @PostMapping("/create-post")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
}
