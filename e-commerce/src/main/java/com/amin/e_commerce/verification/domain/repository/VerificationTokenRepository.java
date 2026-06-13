package com.amin.e_commerce.verification.domain.repository;

import com.amin.e_commerce.verification.domain.model.VerificationToken;

import java.util.Optional;

public interface VerificationTokenRepository {
    VerificationToken save(VerificationToken token);

    Optional<VerificationToken> findOptionalByCode(String code);
}
