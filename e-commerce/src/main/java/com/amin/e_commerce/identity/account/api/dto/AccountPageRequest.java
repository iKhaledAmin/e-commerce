package com.amin.e_commerce.identity.account.api.dto;

import com.amin.e_commerce.core.pagination.PageRequest;
import com.amin.e_commerce.core.pagination.SortField;
import com.amin.e_commerce.identity.account.domain.model.AccountSortField;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountPageRequest extends PageRequest {
    private AccountSortField sortBy = AccountSortField.CREATED_AT;

    @Override
    public SortField getSortBy() {
        return sortBy;
    }
}