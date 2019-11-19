package com.example.authentication.userservice.repostory;

import com.example.authentication.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gary Cheng
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find user by username
     *
     * @param username
     * @return
     */
    User findByUsername(String username);
}
