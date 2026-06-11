package com.amin.e_commerce.core.mapper;


public interface BaseMapper<RESPONSE, ENTITY> {

    // Response
    RESPONSE toResponse(ENTITY entity);
}