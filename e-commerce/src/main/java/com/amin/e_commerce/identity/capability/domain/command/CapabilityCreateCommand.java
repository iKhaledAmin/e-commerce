package com.amin.e_commerce.identity.capability.domain.command;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.value.*;
import com.amin.e_commerce.identity.core.model.ActorType;

public record CapabilityCreateCommand(
        CapabilityCode code,
        CapabilityResource resource,
        CapabilityAction action,
        CapabilityName name,
        CapabilityDescription description,
        SystemDomain domain,
        ActorType expectedActorType
) {
    public static CapabilityCreateCommand of(
            String code,
            String resource,
            String action,
            String name,
            String description,
            SystemDomain domain,
            ActorType expectedActorType
    ){
      return new CapabilityCreateCommand(
              CapabilityCode.of(code),
              CapabilityResource.of(resource),
              CapabilityAction.of(action),
              CapabilityName.of(name),
              CapabilityDescription.of(description),
              domain,
              expectedActorType
      )  ;
    }
}
