package com.amin.e_commerce.identity.role.api.controller;


import com.amin.e_commerce.core.api.ActionResponse;
import com.amin.e_commerce.core.api.ApiResponse;
import com.amin.e_commerce.core.api.ApiResponseFactory;
import com.amin.e_commerce.identity.capability.domain.value.CapabilityCode;
import com.amin.e_commerce.identity.role.api.dto.RoleCreateRequest;
import com.amin.e_commerce.identity.role.api.dto.RoleResponse;
import com.amin.e_commerce.identity.role.api.dto.RoleUpdateRequest;
import com.amin.e_commerce.identity.role.api.mapper.RoleMapper;
import com.amin.e_commerce.identity.role.application.service.RoleService;
import com.amin.e_commerce.identity.role.domain.model.Role;
import com.amin.e_commerce.identity.role.domain.value.RoleName;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @PostMapping
    @PreAuthorize("hasAuthority('role_create')")
    public ResponseEntity<ApiResponse<RoleResponse>> create(@Valid @RequestBody RoleCreateRequest request) {

        Role role = roleService.createBusinessRole(request);
        RoleResponse response =roleMapper.toResponse(role);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    ApiResponseFactory.success(response)
                );
    }

    @PatchMapping("/{roleName}")
    @PreAuthorize("hasAuthority('role_update')")
    public ResponseEntity<ApiResponse<RoleResponse>> update(@PathVariable String roleName, @Valid @RequestBody RoleUpdateRequest request) {

        Role role = roleService.update(
                RoleName.of(roleName),
                request
        );
        RoleResponse response = roleMapper.toResponse(role);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }

    @DeleteMapping("/{roleName}")
    @PreAuthorize("hasAuthority('role_delete')")
    public ResponseEntity<ApiResponse<ActionResponse>> delete(@PathVariable String roleName) {

        roleService.delete(RoleName.of(roleName));
        ActionResponse response = ActionResponse
                .builder()
                .message("Role deleted successfully")
                .build();

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }

    @GetMapping("/{roleName}")
    @PreAuthorize("hasAuthority('role_read')")
    public ResponseEntity<ApiResponse<RoleResponse>> viewRole(@PathVariable String roleName) {

        Role role = roleService.viewRole(
                RoleName.of(roleName)
        );
        RoleResponse response = roleMapper.toResponse(role);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }


    @GetMapping
    @PreAuthorize("hasAuthority('role_read')")
    public ResponseEntity<ApiResponse<List<RoleResponse>>> listRoles() {
        List<Role> roles = roleService.listRoles();

        List<RoleResponse> responses = roles
                .stream()
                .map(roleMapper::toResponse)
                .toList();

        return ResponseEntity.ok(
                ApiResponseFactory.success(responses)
        );
    }

    @PutMapping("/{roleName}/capabilities/{capabilityCode}")
    @PreAuthorize("hasAuthority('role_add_capability')")
    public ResponseEntity<ApiResponse<RoleResponse>> addCapability(@PathVariable String roleName, @PathVariable String capabilityCode) {

        Role role = roleService.addCapability(
                RoleName.of(roleName),
                CapabilityCode.of(capabilityCode)
        );
        RoleResponse response =  roleMapper.toResponse(role);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }

    @DeleteMapping("/{roleName}/capabilities/{capabilityCode}")
    @PreAuthorize("hasAuthority('role_remove_capability')")
    public ResponseEntity<ApiResponse<RoleResponse>> removeCapability(@PathVariable String roleName, @PathVariable String capabilityCode) {

        Role role = roleService.removeCapability(
                RoleName.of(roleName),
                CapabilityCode.of(capabilityCode)
        );
        RoleResponse response = roleMapper.toResponse(role);

        return ResponseEntity.ok(
                ApiResponseFactory.success(response)
        );
    }
}