package com.amin.e_commerce.identity.role.api.controller;



import com.amin.e_commerce.core.api.ApiResponse;
import com.amin.e_commerce.core.api.ApiResponseFactory;
import com.amin.e_commerce.identity.role.api.dto.RoleResponse;
import com.amin.e_commerce.identity.role.api.mapper.RoleMapper;
import com.amin.e_commerce.identity.role.application.service.RoleManagementService;
import com.amin.e_commerce.identity.role.domain.model.Role;
import com.amin.e_commerce.identity.role.domain.value.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleManagementService roleManagementService;
    private final RoleMapper roleMapper;


    @GetMapping("/{roleName}")
    @PreAuthorize("hasAuthority('role_read')")
    public ResponseEntity<ApiResponse<RoleResponse>> viewRole(@PathVariable String roleName) {

        Role role = roleManagementService.viewRole(
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
        List<Role> roles = roleManagementService.listRoles();

        List<RoleResponse> responses = roles
                .stream()
                .map(roleMapper::toResponse)
                .toList();

        return ResponseEntity.ok(
                ApiResponseFactory.success(responses)
        );
    }

}