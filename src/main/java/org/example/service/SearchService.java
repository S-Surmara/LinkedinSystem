package org.example.service;

import org.example.entity.Post;
import org.example.entity.Profile;
import org.example.entity.SearchResult;
import org.example.enums.SearchResultType;
import org.example.persistance.PostPersistence;
import org.example.repositry.ProfileRepository;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private ProfileRepository profileRepository;
    private PostPersistence postPersistence;

    public SearchService(ProfileRepository profileRepository, PostPersistence postPersistence) {
        this.profileRepository = profileRepository;
        this.postPersistence = postPersistence;
    }

    public List<SearchResult> searchUsers(String query) {
        List<SearchResult> results = new ArrayList<>();
        List<Profile> profiles = profileRepository.searchProfiles(query);

        for (Profile profile : profiles) {
            double relevanceScore = calculateRelevance(query, profile.getName(), profile.getSummary());
            SearchResult result = new SearchResult(
                    profile.getUuid(),
                    SearchResultType.USER,
                    profile,
                    relevanceScore
            );
            results.add(result);
        }

        results.sort((r1, r2) -> Double.compare(r2.getRelevanceScore(), r1.getRelevanceScore()));
        return results;
    }

    public List<SearchResult> searchPosts(String query) {
        List<SearchResult> results = new ArrayList<>();
        List<Post> allPosts = postPersistence.getAllPosts();

        for (Post post : allPosts) {
            if (post.getPostDescription().toLowerCase().contains(query.toLowerCase())) {
                double relevanceScore = calculateRelevance(query, post.getPostDescription(), "");
                SearchResult result = new SearchResult(
                        post.getPostId(),
                        SearchResultType.POST,
                        post,
                        relevanceScore
                );
                results.add(result);
            }
        }

        results.sort((r1, r2) -> Double.compare(r2.getRelevanceScore(), r1.getRelevanceScore()));
        return results;
    }

    public List<SearchResult> searchAll(String query) {
        List<SearchResult> results = new ArrayList<>();
        results.addAll(searchUsers(query));
        results.addAll(searchPosts(query));
        results.sort((r1, r2) -> Double.compare(r2.getRelevanceScore(), r1.getRelevanceScore()));
        return results;
    }

    private double calculateRelevance(String query, String... fields) {
        double score = 0.0;
        String lowerQuery = query.toLowerCase();

        for (String field : fields) {
            if (field != null && !field.isEmpty()) {
                String lowerField = field.toLowerCase();
                if (lowerField.contains(lowerQuery)) {
                    score += 1.0;
                    if (lowerField.startsWith(lowerQuery)) {
                        score += 0.5;
                    }
                }
            }
        }
        return score;
    }
}
