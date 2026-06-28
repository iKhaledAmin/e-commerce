package com.amin.e_commerce.media.core.storage;

import java.io.InputStream;

public interface StorageProvider {

    void store(String storageKey, InputStream content);

    InputStream load(String storageKey);

    void delete(String storageKey);

    boolean exists(String storageKey);

}