package Project.ai_workspace_platform.security;

import Project.ai_workspace_platform.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }



    public String generateAccessToken(User user) {

        return Jwts.builder()
                .subject(user.getEmail())                  // Email as subject
                .claim("userId", user.getId())             // User Id as custom claim
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(getSecretKey())
                .compact();
    }



    public String generateRefreshToken(User user) {

        return Jwts.builder()
                .subject(user.getEmail())
                .claim("userId", user.getId())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()
                        + 1000L * 60 * 60 * 24 * 30 * 6)) // 6 months
                .signWith(getSecretKey())
                .compact();
    }



    private Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }



    public Long getUserIdFromToken(String token) {

        Claims claims = extractAllClaims(token);

        Object userId = claims.get("userId");

        if (userId instanceof Integer) {
            return ((Integer) userId).longValue();
        }

        if (userId instanceof Long) {
            return (Long) userId;
        }

        return Long.valueOf(userId.toString());
    }

    public String getEmailFromToken(String token) {
        return extractAllClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }

    public boolean validateToken(String token, User user) {

        String email = getEmailFromToken(token);

        return email.equals(user.getEmail()) && !isTokenExpired(token);
    }

}