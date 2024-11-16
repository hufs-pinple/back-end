package com.hufs.module.account.dtos;

import com.hufs.module.account.entities.Account;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AccountResponseDTO {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class UserOverview {
        private Long id;
        private String username;
        private Long point;

        public static UserOverview of(Account account) {
            return UserOverview.builder()
                    .id(account.getId())
                    .username(account.getUsername())
                    .point(account.getPoint())
                    .build();
        }

    }
}
