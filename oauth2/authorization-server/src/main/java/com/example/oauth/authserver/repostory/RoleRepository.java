package com.example.oauth.authserver.repostory;

import com.example.oauth.authserver.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

/**
 * @author Gary Cheng
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Find Role by roleName
     *
     * @param roleName
     * @return
     */
    User findByRoleName(String roleName);
}
