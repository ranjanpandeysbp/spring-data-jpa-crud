package com.asb.example.controller;

import com.asb.example.model.CommentModel;
import com.asb.example.model.PostModel;
import com.asb.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public PostModel[] getAllPosts(){
        PostModel[] response = postService.getAllPosts();
        return response;
    }

    @GetMapping("/posts/{postId}/comments")
    public CommentModel[] getAllCommentsForApost(@PathVariable("postId") Long postId){
        return postService.getAllCommentsForApost(postId);
    }

    @PostMapping("/posts")
    public PostModel createPost(@RequestBody PostModel postModel){
        PostModel model = postService.createPost(postModel);
        return model;
    }

    @PutMapping("/posts/{postId}")
    public PostModel updatePost(@RequestBody PostModel postModel, @PathVariable("postId") Long postId){
        PostModel model = postService.updatePost(postModel, postId);
        return model;
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
    }

}
