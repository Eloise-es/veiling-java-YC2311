package com.example.veilingsite.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.veilingsite.domain.JwtTokenProvider;

@Configuration
public class JwtConfig {
    @Bean
    public JwtTokenProvider jwtTokenProvider() {
        Dotenv dotenv = Dotenv.load();
        String secretKey = dotenv.get("JWT_SECRET_KEY");
        long validityInMilliseconds = 3600000; // 1 hour
//        long validityInMilliseconds = 3000; // 3 seconds (for testing)
        return new JwtTokenProvider(secretKey, validityInMilliseconds);
    }
}