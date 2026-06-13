package com.amin.e_commerce.identity.account.domain.model;

import com.amin.e_commerce.core.pagination.SortField;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AccountSortField implements SortField {

    USERNAME("username"),
    LAST_LOGIN("lastLogin"),
    CREATED_AT("createdAt");

    private final String field

    ;

    @Override
    public String getField() {
        return field;
    }
}
