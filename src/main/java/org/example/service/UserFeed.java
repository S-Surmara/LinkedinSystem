package org.example.service;

import org.example.entity.Post;

import java.util.List;

public class UserFeed {
    private PostService postService;

    public UserFeed(PostService postService) {
        this.postService = postService;
    }

    public List<Post> getRelatedPosts(List<Post> posts) {
        return posts;
    }
}
