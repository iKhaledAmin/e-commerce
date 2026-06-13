package com.amin.e_commerce.identity.account.application.service;


import com.amin.e_commerce.identity.account.domain.repository.AccountRepository;
import com.amin.e_commerce.identity.role.application.service.RoleUsageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleUsageServiceImpl implements RoleUsageService {

    private final AccountRepository accountRepository;

    @Override
    public boolean isAssignedToAnyAccount(Long roleId) {
        return accountRepository.existsByRoleId(roleId);
    }
}