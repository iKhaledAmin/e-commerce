package com.amin.e_commerce.identity.core.generator;


import com.github.f4b6a3.ulid.UlidCreator;
import com.amin.e_commerce.identity.core.exception.IdentityTechnicalException;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorType;
import com.amin.e_commerce.core.exception.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class UlidActorCodeGenerator implements ActorCodeGenerator {

    @Override
    public ActorCode generate(ActorType actorType) {

        // Technical actors use stable predefined code
        if (actorType.isTechnicalActor()) {
            return ActorCode.of(actorType.getCodePrefix());
        }

        // Domain actors get generated unique identity
        String value = actorType.getCodePrefix() + "_" + UlidCreator.getUlid();


        try {
            return ActorCode.of(value);
        }catch (ValidationException e){
            throw IdentityTechnicalException.invalidGeneratedActorCode(e)
                    .withDebugDetails("reason",e.getMessage())
                    .withDebugDetails("actorType", actorType)
                    .withDebugDetails("generatedValue",value);
        }
    }
}