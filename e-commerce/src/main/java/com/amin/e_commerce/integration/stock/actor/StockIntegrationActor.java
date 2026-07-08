package com.amin.e_commerce.integration.stock.actor;

import com.amin.e_commerce.identity.core.model.AbstractActor;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorIdentity;
import com.amin.e_commerce.identity.core.model.ActorType;

public class StockIntegrationActor extends AbstractActor {

    private static final ActorIdentity IDENTITY =
            ActorIdentity.of(
                    ActorType.INVENTORY,
                    ActorCode.of(ActorType.INVENTORY.getCodePrefix())
            );

    public static final StockIntegrationActor INSTANCE = new StockIntegrationActor();

    private StockIntegrationActor() {
        super(IDENTITY);
    }
    @Override
    public boolean hasAuthority(String authority) {
        return false;
    }
}
