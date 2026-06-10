package com.amin.e_commerce.core.pagination;

public enum SortDirection {
    ASC,
    DESC
    ;
    public static SortDirection getDefault() {
        return DESC;
    }
}