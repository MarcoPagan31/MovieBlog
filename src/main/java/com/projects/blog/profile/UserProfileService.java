package com.projects.blog.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public List<UserProfile> getUserProfiles() {
        return userProfileRepository.findAll();
    }

    public void addNewProfile(UserProfile profile) {
        Optional<UserProfile> profileByEmail = userProfileRepository
                .findProfileByEmail(profile.getEmail());

        if (profileByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        userProfileRepository.save(profile);
    }
}
