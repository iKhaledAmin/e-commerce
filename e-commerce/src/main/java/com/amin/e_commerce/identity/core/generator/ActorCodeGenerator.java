package com.amin.e_commerce.identity.core.generator;


import com.amin.e_commerce.core.generator.UlidGenerator;
import com.amin.e_commerce.identity.core.model.ActorCode;
import com.amin.e_commerce.identity.core.model.ActorType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ActorCodeGenerator {

    public static ActorCode generate(ActorType actorType) {

        // Technical actors use stable predefined code
        if (actorType.isTechnicalActor()) {
            return ActorCode.of(
                    actorType.getCodePrefix()
            );
        }


        // Domain actors get generated unique identity
        return ActorCode.of(
                actorType.getCodePrefix() + "-" + UlidGenerator.generate()
        );
    }
}