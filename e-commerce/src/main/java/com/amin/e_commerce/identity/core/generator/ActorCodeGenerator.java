package com.amin.e_commerce.identity.core.generator;


import com.amin.e_commerce.core.generator.UniqueIdentifierGenerator;
import com.github.f4b6a3.ulid.UlidCreator;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ActorCodeGenerator {

    private final UniqueIdentifierGenerator generator;


    public ActorCode generate(ActorType actorType) {

        // Technical actors use stable predefined code
        if (actorType.isTechnicalActor()) {
            return ActorCode.of(
                    actorType.getCodePrefix()
            );
        }


        // Domain actors get generated unique identity
        return ActorCode.of(
                generator.generate()
        );
    }
}