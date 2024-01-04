package com.example.veilingsite.view;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.domain.JwtTokenProvider;
import com.example.veilingsite.domain.UserCredentials;
import com.example.veilingsite.persist.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class AuthEndpoint {

    @Autowired
    AccountService as;

    private final JwtTokenProvider jwtTokenProvider;

    public AuthEndpoint(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserCredentials credentials) {
        try {
            boolean isValidUser = checkUserCredentials(credentials);

            if (isValidUser) {
                String token = jwtTokenProvider.createToken(credentials.getEmail());
                return ResponseEntity.ok(Collections.singletonMap("token", token)); // Return token as part of JSON
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (Exception e) {
            // Log exception for internal tracking
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login error");
        }
    }

    private boolean checkUserCredentials(UserCredentials credentials) {
        // Implement your user authentication logic here
        Account account = as.getAccountByEmail(credentials.getEmail());
        return credentials.checkCredentials(account);
        // Return true if valid, false otherwise
    }
}