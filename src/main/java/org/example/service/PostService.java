package org.example.service;

import org.example.entity.Post;
import org.example.entity.User;
import org.example.persistance.PostPersistence;
import org.example.stratergy.PostListingStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PostService {
    private PostListingStrategy postListingStrategy;
    private PostPersistence postPersistence;

    public PostService(PostListingStrategy postListingStrategy, PostPersistence postPersistence) {
        this.postListingStrategy = postListingStrategy;
        this.postPersistence = postPersistence;
    }

    public Post createPost(User user, String description, LocalDateTime timestamp) {
        String postId = UUID.randomUUID().toString();
        Post post = new Post(postId, description, timestamp, user);
        postPersistence.savePost(post);
        return post;
    }

    public List<Post> getPosts(User user) {
        List<Post> posts = postPersistence.getUserPosts(user);
        return postListingStrategy.getPosts(posts);
    }

    public void setPostListingStrategy(PostListingStrategy strategy) {
        this.postListingStrategy = strategy;
    }
}
