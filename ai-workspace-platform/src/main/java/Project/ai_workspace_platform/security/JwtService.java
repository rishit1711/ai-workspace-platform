package Project.ai_workspace_platform.security;

import Project.ai_workspace_platform.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secretKey}")
    private  String jwtSecretKey;

    private SecretKey getSecretKey() {

        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }


    public String generateAccessToken(User user){
        return Jwts.builder()
                .subject(user.getEmail())
                .claim("userId",user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSecretKey())
                .compact();

    }

    public String GenerateRefreshToken(User user){
        return Jwts.builder()
                .subject(user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60*24*30*6))
                .signWith(getSecretKey())
                .compact();

    }




}
