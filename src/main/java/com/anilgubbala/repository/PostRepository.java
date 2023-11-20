package com.anilgubbala.repository;

import com.anilgubbala.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PostRepository extends JpaRepository<Post, Long> {
}
