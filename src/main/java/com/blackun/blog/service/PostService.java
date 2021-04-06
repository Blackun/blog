package com.blackun.blog.service;

import com.blackun.blog.entities.Post;
import com.blackun.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void insert(Post post) {
        if(Objects.isNull(post.getDateCreated())){
            post.setDateCreated(new Date());
        }
        postRepository.save(post);
    }
}
