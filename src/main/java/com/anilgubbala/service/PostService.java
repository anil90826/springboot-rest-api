package com.anilgubbala.service;

import com.anilgubbala.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts(int pageNum, int pageSize);
    PostDto getPostById(Long postId);
    PostDto updatePost(PostDto postDto, long postId);

    void deletePostById(Long postId);
}
