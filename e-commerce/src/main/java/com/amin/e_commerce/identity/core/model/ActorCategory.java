package com.amin.e_commerce.identity.core.model;

public enum ActorCategory {
    /**
     * Real business/domain identities
     * persisted in the system database.
     */
    DOMAIN,

    /**
     * Internal runtime/system identities
     * used by infrastructure and framework operations.
     */
    TECHNICAL
}
