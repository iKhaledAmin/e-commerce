package com.amin.e_commerce.verification.infrastructure.persistence;

import com.amin.e_commerce.verification.domain.model.VerificationToken;
import com.amin.e_commerce.core.persistence.BaseRepository;

import java.util.Optional;

public interface VerificationTokenJpaRepository extends BaseRepository<VerificationToken,Long> {
    Optional<VerificationToken> findByCode(String code);
}
