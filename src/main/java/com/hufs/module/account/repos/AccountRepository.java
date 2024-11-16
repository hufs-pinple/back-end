package com.hufs.module.account.repos;

import com.hufs.module.account.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryExtension {
}
