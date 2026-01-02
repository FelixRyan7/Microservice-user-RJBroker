package com.broker.user_service.DTOs;

import com.broker.user_service.model.UserProfile;

public class JwtResponse {

    private String token;
    private String username;
    private Long userId;
    private Boolean hasPersonalData;
    private String fullName;
    private UserProfile.UserLevel userLevel;

    // Constructor


    public JwtResponse(String token, String username, Long userId, Boolean hasPersonalData, String fullName, UserProfile.UserLevel userLevel) {
        this.token = token;
        this.username = username;
        this.userId = userId;
        this.hasPersonalData = hasPersonalData;
        this.fullName = fullName;
        this.userLevel = userLevel;
    }

    // Getters y Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getHasPersonalData() {
        return hasPersonalData;
    }

    public void setHasPersonalData(Boolean hasPersonalData) {
        this.hasPersonalData = hasPersonalData;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserProfile.UserLevel getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(UserProfile.UserLevel userLevel) {
        this.userLevel = userLevel;
    }
}
