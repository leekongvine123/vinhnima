package com.lcvinh.demo.utils;

import com.lcvinh.demo.user.dto.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtService {

    private static final String SECRET_KEY = "lecongvinhhelloworld123@gmail.com";
    private static final long ACCESS_TOKEN_EXPIRE = 24 * 60 * 60 * 1000; // 24 hours

    public static String generateToken(String email, Role role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role.name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }

    public static Claims decodeToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid token.");
        }
    }

    public static boolean isExpired(String token) {
        try {
            Claims claims = decodeToken(token);
            Date expirationDate = claims.getExpiration();
            return expirationDate.before(new Date());
        } catch (ExpiredJwtException ex) {
            return true;
        }
    }

    public static boolean validateToken(String token) {
        try {
            decodeToken(token); // Decode to check validity
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
