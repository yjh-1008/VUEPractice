package com.example.gallery.backend.service;

import io.jsonwebtoken.Claims;

public interface JwtService {
    public String getToken(String key, Object value);
    Claims getClaims(String token);

    boolean isValid(String token);

    int getId(String token);
}
