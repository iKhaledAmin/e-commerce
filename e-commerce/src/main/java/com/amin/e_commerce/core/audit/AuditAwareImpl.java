package com.amin.e_commerce.core.audit;

import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.identity.core.provider.ActorProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuditAwareImpl implements AuditorAware<ActorIdentity> {

    private final ActorProvider actorProvider;

    @Override
    public Optional<ActorIdentity> getCurrentAuditor() {

        Actor actor = actorProvider.getCurrent();

        return Optional.of(
                actor.getActorIdentity()
        );
    }
}

