package com.example.oauth.authserver;

import com.example.oauth.authserver.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Gary Cheng
 */
public class UserPrincipal extends org.springframework.security.core.userdetails.User {
    private User user;

    public UserPrincipal(User user) {
        super(user.getUsername(), user.getPassword(), user.isActivated(), true, true, true, getAuthorities(user));
        this.user = user;
    }

    private static Collection<GrantedAuthority> getAuthorities(User user) {
        return user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getRoleName())).collect(Collectors.toSet());
    }

    public User getUser() {
        return user;
    }
}
