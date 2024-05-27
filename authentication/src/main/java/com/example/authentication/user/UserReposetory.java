package com.example.authentication.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserReposetory extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
