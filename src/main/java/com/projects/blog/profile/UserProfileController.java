package com.projects.blog.profile;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("api/v1/user-profile")
@CrossOrigin(origins = "*")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public List<UserProfile> getUserProfiles() {
        return userProfileService.getUserProfiles();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void registerProfile(@RequestBody UserProfile profile) {
        userProfileService.addNewProfile(profile);
    }

}
