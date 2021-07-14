package com.projects.blog.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    @Query("SELECT p FROM UserProfile p WHERE p.email = ?1")
    Optional<UserProfile> findProfileByEmail(String email);
}
