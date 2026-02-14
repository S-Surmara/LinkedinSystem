package org.example.repositry;

import org.example.entity.Profile;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileRepository {
    private Map<User, Profile> userProfiles;

    public ProfileRepository() {
        this.userProfiles = new HashMap<>();
    }

    public void saveProfile(User user, Profile profile) {
        userProfiles.put(user, profile);
    }

    public Profile getProfile(User user) {
        return userProfiles.get(user);
    }

    public List<Profile> getAllProfiles() {
        return new ArrayList<>(userProfiles.values());
    }

    public List<Profile> searchProfiles(String keyword) {
        List<Profile> results = new ArrayList<>();
        for (Profile profile : userProfiles.values()) {
            if (profile.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    profile.getSummary().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(profile);
            }
        }
        return results;
    }
}
