package com.anilgubbala.service.impl;

import com.anilgubbala.domain.Post;
import com.anilgubbala.exception.ResourceNotFoundException;
import com.anilgubbala.payload.PostDto;
import com.anilgubbala.repository.PostRepository;
import com.anilgubbala.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    //@Autowired -- can be omitted if a class configured as spring bean and has only one constructor
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post postEntity = mapToEntity(postDto);
        final Post newPost = postRepository.save(postEntity);
        PostDto postsResponse = mapToDto(newPost);

        return postsResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {

         List<Post> listOfPosts = postRepository.findAll();
         return listOfPosts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow( () -> new ResourceNotFoundException("Post", "postId", postId ));
        return mapToDto(post);
    }

    /**
     * Convert Entity to Dto
     * @param post
     * @return
     */
    private PostDto mapToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setPostId(post.getPostId());
        postDto.setPostTitle(post.getPostTitle());
        postDto.setPostDescription(post.getPostDescription());
        postDto.setPostContent(post.getPostContent());
        return postDto;
    }

    /**
     * Convert Dto to entity
     * @param postDto
     * @return
     */
    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setPostTitle(postDto.getPostTitle());
        post.setPostDescription(postDto.getPostDescription());
        post.setPostContent(postDto.getPostContent());

        return post;
    }


}
