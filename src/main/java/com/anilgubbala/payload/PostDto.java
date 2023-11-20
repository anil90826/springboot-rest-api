package com.anilgubbala.payload;

import lombok.Data;

@Data
public class PostDto {

    private Long id;
    private String postTitle;
    private String postDescription;
    private String postContent;
}
