package com.broker.user_service.DTOs;

import com.broker.user_service.model.UserProfile;

public class UserProfileResponse {

    private Long id;
    private String fullName;

    private UserProfile.UserLevel userLevel;

    public UserProfileResponse(Long id, String fullName, UserProfile.UserLevel userLevel) {
        this.id = id;
        this.fullName = fullName;
        this.userLevel = userLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
