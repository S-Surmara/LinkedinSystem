package org.example.stratergy;

import org.example.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

public class LatestUploadedStrategy implements PostListingStrategy {

    @Override
    public List<Post> getPosts(List<Post> posts) {
        return posts.stream()
                .sorted((p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()))
                .collect(Collectors.toList());
    }
}
