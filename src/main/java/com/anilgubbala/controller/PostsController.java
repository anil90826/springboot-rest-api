package com.anilgubbala.controller;

import com.anilgubbala.payload.PostDto;
import com.anilgubbala.repository.PostRepository;
import com.anilgubbala.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    private PostService postService;

    @Autowired
    private PostRepository  postRepository;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all-posts?")
    public List<PostDto> getAllPosts(
            @RequestParam(value = "pageNum", defaultValue = "0", required = false) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {

        return postService.getAllPosts(pageNum, pageSize);
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

    @DeleteMapping("/post/{post-id}/delete")
    public ResponseEntity<String> deletePost(@PathVariable("post-id") Long postId) {
        postService.deletePostById(postId);
        return new ResponseEntity("post has been deleted",HttpStatus.OK);
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
