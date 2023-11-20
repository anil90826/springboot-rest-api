package com.anilgubbala.controller;

import com.anilgubbala.domain.Post;
import com.anilgubbala.payload.PostDto;
import com.anilgubbala.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    private PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all-posts")
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/post/{post-id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("post-id") Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @PutMapping("/post/{post-id}/update")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable("post-id") Long postId) {
        PostDto response = postService.updatePost(postDto, postId);
        return new ResponseEntity(response, HttpStatus.OK);
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
