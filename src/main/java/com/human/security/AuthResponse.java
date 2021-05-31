package com.human.security;

public class AuthResponse {
    private final String JWT;

    public AuthResponse(String jwt){
        this.JWT = jwt;
    }

    public String getJWT() {
        return JWT;
    }

}
