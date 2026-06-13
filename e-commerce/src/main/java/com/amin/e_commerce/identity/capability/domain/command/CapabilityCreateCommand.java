package com.amin.e_commerce.identity.capability.domain.command;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.domain.value.*;

public record CapabilityCreateCommand(
        CapabilityCode code,
        CapabilityResource resource,
        CapabilityAction action,
        CapabilityName name,
        CapabilityDescription description,
        SystemDomain domain
) {
    public static CapabilityCreateCommand of(
            String code,
            String resource,
            String action,
            String name,
            String description,
            SystemDomain domain
    ){
      return new CapabilityCreateCommand(
              CapabilityCode.of(code),
              CapabilityResource.of(resource),
              CapabilityAction.of(action),
              CapabilityName.of(name),
              CapabilityDescription.of(description),
              domain
      )  ;
    }
}
