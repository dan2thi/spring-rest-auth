package com.example.authentication.oauth.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Gary Cheng
 */
@Slf4j
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {
    @GetMapping("/welcome")
    public ApiResponse home() {
        return new ApiResponse("Public Api");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ApiResponse admin() {
        return new ApiResponse("Admin Api");
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public ApiResponse user(Principal principal) {
        log.info("principal:{}", principal);
        return new ApiResponse("User Api");
    }

}
