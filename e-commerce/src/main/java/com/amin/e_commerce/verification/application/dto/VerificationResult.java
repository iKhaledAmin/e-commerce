package com.amin.e_commerce.verification.application.dto;

import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.verification.domain.model.TokenType;

public record VerificationResult(ActorIdentity target, TokenType type)
{}