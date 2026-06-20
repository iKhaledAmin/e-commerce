package com.amin.e_commerce.identity.capability.api.contoller;


import com.amin.e_commerce.core.api.response.ApiResponse;
import com.amin.e_commerce.core.api.response.ApiResponseFactory;
import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.identity.capability.api.dto.CapabilityResponse;
import com.amin.e_commerce.identity.capability.api.mapper.CapabilityMapper;
import com.amin.e_commerce.identity.capability.application.service.CapabilityManagementService;
import com.amin.e_commerce.identity.capability.domain.model.Capability;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("capabilities")
@RequiredArgsConstructor
public class CapabilityController {

    private final CapabilityManagementService capabilityManagementService;
    private final CapabilityMapper capabilityMapper;



    @PreAuthorize("hasAuthority('capability_read')")
    @GetMapping("/{code}")
    public ResponseEntity<ApiResponse<CapabilityResponse>> view(@PathVariable String code) {

        Capability capability = capabilityManagementService.viewCapability(CapabilityCode.of(code));

        CapabilityResponse response = capabilityMapper.toResponse(capability);
        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }

    @PreAuthorize("hasAuthority('capability_read')")
    @GetMapping
    public ResponseEntity<ApiResponse<List<CapabilityResponse>>> list(
            @RequestParam(required = false) SystemDomain domain) {

        List<Capability> capabilities = capabilityManagementService.listCapabilities(domain);

        List<CapabilityResponse> response = capabilities
                .stream()
                .map(capabilityMapper::toResponse).
                toList();

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }


}