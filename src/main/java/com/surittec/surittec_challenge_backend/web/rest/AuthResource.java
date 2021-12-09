package com.surittec.surittec_challenge_backend.web.rest;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthResource {

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/auth")
    public ResponseEntity<Object> activateAccount() {
        HashMap<String, String> response = new HashMap<>();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        response.put("role", username);
        System.out.printf("Request to check auth as %s%n", username);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
