package com.anilgubbala.service;

import com.anilgubbala.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();
    PostDto getPostById(Long postId);
}
