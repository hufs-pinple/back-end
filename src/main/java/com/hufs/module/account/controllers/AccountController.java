package com.hufs.module.account.controllers;


import com.hufs.module.account.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService service;

    @GetMapping
    public ResponseEntity<?> fetchUserInfo(
            @RequestParam Long accountId
    ){
        return service.fetchUserInfo(accountId);
    }
}
