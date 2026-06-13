package com.amin.e_commerce.verification.infrastructure.persistence;

import com.amin.e_commerce.verification.domain.model.VerificationToken;
import com.amin.e_commerce.verification.domain.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class VerificationTokenRepositoryImpl implements VerificationTokenRepository {

    private final VerificationTokenJpaRepository verificationTokenJpaRepository;

    @Override
    public VerificationToken save(VerificationToken verificationToken) {
        return verificationTokenJpaRepository.save(verificationToken);
    }

    @Override
    public Optional<VerificationToken> findOptionalByCode(String code) {
        return verificationTokenJpaRepository.findByCode(code);
    }

}
