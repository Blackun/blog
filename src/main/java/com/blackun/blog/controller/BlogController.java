package com.blackun.blog.controller;

import com.blackun.blog.entities.Post;
import com.blackun.blog.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    private final PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value="/")
    public String index(){
        return "index";
    }

    @GetMapping(value="/posts")
    public List<Post> posts(){
        return postService.getAllPosts();
    }

    @PostMapping(value="/post")
    public void publishPost(@RequestBody Post post){
        postService.insert(post);
    }
}
