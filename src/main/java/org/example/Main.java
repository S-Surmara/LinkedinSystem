package org.example;

import org.example.entity.Notification;
import org.example.entity.Profile;
import org.example.entity.SearchResult;
import org.example.entity.User;
import org.example.persistance.ConnectionPersistence;
import org.example.persistance.MessagePersistence;
import org.example.persistance.NotificationPersistence;
import org.example.persistance.PostPersistence;
import org.example.repositry.ProfileRepository;
import org.example.service.*;
import org.example.stratergy.LatestUploadedStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ConnectionPersistence connectionPersistence = new ConnectionPersistence();
        MessagePersistence messagePersistence = new MessagePersistence();
        PostPersistence postPersistence = new PostPersistence();
        NotificationPersistence notificationPersistence = new NotificationPersistence();
        ProfileRepository profileRepository = new ProfileRepository();

        // Initialize services
        NotificationService notificationService = new NotificationService(notificationPersistence);
        ConnectionService connectionService = new ConnectionService(connectionPersistence, notificationService);
        MessagingService messagingService = new MessagingService(connectionService, messagePersistence, notificationService);
        PostService postService = new PostService(new LatestUploadedStrategy(), postPersistence);
        SearchService searchService = new SearchService(profileRepository, postPersistence);
        AuthenticationService authService = new AuthenticationService();

        // Create users
        User user1 = authService.registerUser("Alice", "alice@example.com", "password123");
        User user2 = authService.registerUser("Bob", "bob@example.com", "password456");

        // Create profiles
        Profile profile1 = new Profile("uuid1", "Alice", "Software Engineer", "5 years at OpenText");
        Profile profile2 = new Profile("uuid2", "Bob", "Product Manager", "3 years experience");
        profileRepository.saveProfile(user1, profile1);
        profileRepository.saveProfile(user2, profile2);

        // Send connection request
        connectionService.sendRequest(user1, user2);
        connectionService.acceptRequest(user1, user2);

        // Send message
        messagingService.sendMessage(user1, user2, "Hello Bob!", LocalDateTime.now());

        // Create post
        postService.createPost(user1, "Excited to share my new project!", LocalDateTime.now());

        // Search
        List<SearchResult> searchResults = searchService.searchUsers("Alice");
        System.out.println("Search results: " + searchResults.size());

        // Get notifications
        List<Notification> notifications = notificationService.getUserNotifications(user2);
        System.out.println("User2 has " + notifications.size() + " notifications");

        System.out.println("\n✓ LinkedIn System Demo Completed Successfully!");
    }
}