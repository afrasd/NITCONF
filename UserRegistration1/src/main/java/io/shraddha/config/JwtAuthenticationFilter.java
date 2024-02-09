package io.shraddha.config;
//
//public class JwtAuthenticationFilter {
//
//}
//package com.example.security;

//import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        // Extract token from request
//        String token = extractToken(request);
//        
//        // Validate token and set authentication
//        if (token != null) {
//            Authentication authentication = authenticate(token);
//            if (authentication != null) {
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//        
//        filterChain.doFilter(request, response);
//    }
//
//    private String extractToken(HttpServletRequest request) {
//        // Extract token from Authorization header
//        String bearerToken = request.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7); // Remove "Bearer " prefix
//        }
//        
//        // No token found
//        return null;
//    }
//
//    private Authentication authenticate(String token) {
//        // Validate JWT token
//        Jwt jwt = validateToken(token);
//        
//        // Create authentication object
//        if (jwt != null) {
//            return new JwtAuthenticationToken(jwt);
//        }
//        
//        // Invalid token
//        return null;
//    }
//    
//    private Jwt validateToken(String token) {
//        // Implement token validation logic (e.g., using JwtDecoder)
//        // Return null if token is invalid or expired
//        return null;
//    }
//}



import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtDecoder jwtDecoder;

    public JwtAuthenticationFilter(JwtDecoder jwtDecoder) {
        this.jwtDecoder = jwtDecoder;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Extract token from request
        String token = extractToken(request);
        
        // Validate token and set authentication
        if (token != null) {
            Authentication authentication = authenticate(token);
            if (authentication != null) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        // Extract token from Authorization header
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Remove "Bearer " prefix
        }
        
        // No token found
        return null;
    }

    private Authentication authenticate(String token) {
        // Validate JWT token
        Jwt jwt = validateToken(token);
        
        // Create authentication object
        if (jwt != null) {
            return new JwtAuthenticationToken(jwt);
        }
        
        // Invalid token
        return null;
    }
    
    private Jwt validateToken(String token) {
        // Decode and verify JWT token using JwtDecoder
        try {
            return jwtDecoder.decode(token);
        } catch (Exception e) {
            // Token validation failed
            return null;
        }
    }
}

