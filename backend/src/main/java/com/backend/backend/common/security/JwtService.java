package com.backend.backend.common.security;

import java.nio.charset.StandardCharsets;
import java.util.*;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.backend.backend.auth.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class JwtService {

    public final JwtProperties jwtProperties;

    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(jwtProperties.getSecret()
                                                .getBytes(StandardCharsets.UTF_8)
                                    );       
    }

    public String generateAccessToken(User user){
         Date issuedAt = new Date();
         Date expiration = new Date(
            issuedAt.getTime()
                    + (jwtProperties.getAccessTokenExpiration() * 1000)
    );

        return Jwts.builder()
                .subject(user.getId().toString())
                .claim("username", user.getUsername())
                .claim("email",user.getEmail())
                .issuedAt(issuedAt)
                .expiration(expiration)
                .signWith(getSigningKey()).compact();
    }

    public String extrectUserId(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public boolean isTokenValid(String token){
        try{
            Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token);

            return true;
        }catch(Exception e){
            return false;
        }
    }

}
