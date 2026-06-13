package com.amin.e_commerce.identity.capability.domain.command;

import com.amin.e_commerce.identity.capability.domain.value.CapabilityDescription;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityName;

public record CapabilityUpdateCommand(
        CapabilityName name,
        CapabilityDescription description
) {
    public static CapabilityUpdateCommand of(String name, String description) {
        return new CapabilityUpdateCommand(
                CapabilityName.of(name),
                CapabilityDescription.of(description)
        );
    }
}
