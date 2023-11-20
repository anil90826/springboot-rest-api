package com.anilgubbala.service.impl;

import com.anilgubbala.domain.Post;
import com.anilgubbala.payload.PostDto;
import com.anilgubbala.repository.PostRepository;
import com.anilgubbala.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    //@Autowired -- can be omitted if a class configured as spring bean and has only one constructor
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        //convert Dto to entity
        Post postEntity = new Post();
        postEntity.setPostTitle(postDto.getPostTitle());
        postEntity.setPostDescription(postDto.getPostDescription());
        postEntity.setPostContent(postDto.getPostContent());

        final Post newPost = postRepository.save(postEntity);

        //Convert Entity to post
        PostDto postsResponse = new PostDto();
        postsResponse.setId(newPost.getPostId());
        postsResponse.setPostTitle(newPost.getPostTitle());
        postsResponse.setPostDescription(newPost.getPostDescription());
        postsResponse.setPostContent(newPost.getPostContent());


        return postsResponse;
    }
}
