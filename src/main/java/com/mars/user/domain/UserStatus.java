package com.mars.user.domain;

public enum UserStatus {

    ACTIVE("활동중", true),
    BLOCKED("제한됨", false);

    private final String name;
    private final boolean isActive;


    UserStatus(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }
}
