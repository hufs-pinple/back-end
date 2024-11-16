package com.hufs.module.account.services;

import com.hufs.module.account.dtos.AccountResponseDTO;
import com.hufs.module.account.entities.Account;
import com.hufs.module.account.repos.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public ResponseEntity<?> fetchUserInfo(Long accountId){
        Account account = accountRepository.fetchAccountBy(accountId);

        return ResponseEntity
                .ok(AccountResponseDTO.UserOverview.of(account));
    }
}
