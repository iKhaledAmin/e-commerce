package com.amin.e_commerce.media.core.model;

public enum MediaOwnerType {

    PRODUCT("product"),
    CATEGORY("category"),
    PROFILE("profile");

    private final String folder;

    MediaOwnerType(String folder) {
        this.folder = folder;
    }

    public String folder() {
        return folder;
    }
}