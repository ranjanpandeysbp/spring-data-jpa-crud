package com.asb.example.service;

import com.asb.example.model.CommentModel;
import com.asb.example.model.PostModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PostService {

    public PostModel[] getAllPosts();
    public CommentModel[] getAllCommentsForApost(Long postId);

    public PostModel createPost(PostModel postModel);
    public PostModel updatePost(PostModel postModel, Long postId);
    public void deletePost(Long postId);
}
