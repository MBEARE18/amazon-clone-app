package com.AmazonClone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.AmazonClone.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
