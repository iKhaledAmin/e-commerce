package com.amin.e_commerce.identity.account.api.dto;

import com.amin.e_commerce.core.api.pagination.PageRequest;
import com.amin.e_commerce.identity.account.domain.model.AccountSortField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountPageRequest extends PageRequest {
    private String sortBy = AccountSortField.getDefault();

    @Override
    public String getSortBy() {
        return sortBy;
    }
}