package com.amin.e_commerce.security.jwt;


import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.Set;

@Getter
@AllArgsConstructor
public class JwtPayload {

     // Technical authentication identity
     private final String subject; // username OR clientId

     // Business actor identity
     private final ActorType actorType; // ACCOUNT | CLIENT
     private final ActorCode actorCode;  // accountCode OR clientCode

     // Time-based security
     private final Date issuedAt;
     private final Date expiration;

     // Human like ACCOUNT
     private final Set<String> roles;
     private final Set<String> permissions;

     // Machine like CLIENT or SERVICE
     private final Set<String> scopes;
}