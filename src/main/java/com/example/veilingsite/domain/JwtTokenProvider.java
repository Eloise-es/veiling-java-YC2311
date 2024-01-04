package com.example.veilingsite.domain;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;

public class JwtTokenProvider {

    private String secretKey; // Your secret key
    private long validityInMilliseconds; // Token validity time

    public JwtTokenProvider(String secretKey, long validityInMilliseconds) {
        this.secretKey = secretKey;
        this.validityInMilliseconds = validityInMilliseconds;
    }

    public JwtTokenProvider() {
    }

    public String createToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return JWT.create()
                .withSubject(username)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(Algorithm.HMAC256(secretKey));
    }

    public boolean validateToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            // Invalid token
            return false;
        }
    }

    public String getEmailFromToken(String token) {
        if (token == null || !validateToken(token)) {
            return null; // or throw an exception based on your error handling strategy
        }

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getSubject(); // Since I'm using the email as the subject
        } catch (JWTVerificationException exception) {
            // Log the exception or handle it as per your application's requirement
            return null;
        }
    }
}