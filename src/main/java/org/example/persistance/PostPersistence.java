package org.example.persistance;

import org.example.entity.Post;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostPersistence {
    private Map<User, List<Post>> postList;

    public PostPersistence() {
        this.postList = new HashMap<>();
    }

    public void savePost(Post post) {
        postList.computeIfAbsent(post.getAuthor(), k -> new ArrayList<>()).add(post);
    }

    public List<Post> getUserPosts(User user) {
        return postList.getOrDefault(user, new ArrayList<>());
    }

    public List<Post> getAllPosts() {
        List<Post> allPosts = new ArrayList<>();
        for (List<Post> posts : postList.values()) {
            allPosts.addAll(posts);
        }
        return allPosts;
    }
}
