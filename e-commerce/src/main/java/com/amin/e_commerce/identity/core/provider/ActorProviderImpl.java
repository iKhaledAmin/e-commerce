package com.amin.e_commerce.identity.core.provider;

import com.amin.e_commerce.identity.core.model.Actor;
import com.amin.e_commerce.identity.core.model.ActorSource;
import com.amin.e_commerce.identity.core.registry.ActorPrincipalResolverRegistry;
import com.amin.e_commerce.identity.core.registry.ActorSourceResolverRegistry;
import com.amin.e_commerce.auth.security.core.authentication.AuthenticatedPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActorProviderImpl implements ActorProvider {
    private final AuthenticatedActorProvider authenticatedActorProvider;
    private final ActorPrincipalResolverRegistry principalResolverRegistry;
    private final ActorSourceResolverRegistry sourceResolverRegistry;

    @Override
    public Actor getCurrent() {
        return authenticatedActorProvider.getCurrentActor();
    }

    @Override
    public Actor getFrom(ActorSource source) {
        return sourceResolverRegistry.resolve(source);
    }

    @Override
    public Actor getFrom(AuthenticatedPrincipal principal) {
        return principalResolverRegistry.resolve(principal);
    }


}
