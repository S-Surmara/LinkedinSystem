package org.example.entity;

import java.time.LocalDateTime;

public class Post {
    private String postId;
    private String postDescription;
    private LocalDateTime timestamp;
    private User author;

    public Post(String postId, String postDescription, LocalDateTime timestamp, User author) {
        this.postId = postId;
        this.postDescription = postDescription;
        this.timestamp = timestamp;
        this.author = author;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", postDescription='" + postDescription + '\'' +
                ", timestamp=" + timestamp +
                ", author=" + author.getName() +
                '}';
    }
}
