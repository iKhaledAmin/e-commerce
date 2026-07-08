package com.amin.e_commerce.core.logging.event;

public interface RequestEventLogger {
    void logStart(String method, String path);
    void logComplete(String method, String path,int statusCode, long duration);
}

