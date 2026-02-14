package org.example.stratergy;

import org.example.entity.Post;

import java.util.List;

public interface PostListingStrategy {
    List<Post> getPosts(List<Post> posts);
}
