package com.anilgubbala.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "dbo", name = "posts",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"post_title"})})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_description")
    private String postDescription;

    @Column(name = "post_content")
    private String postContent;
}
