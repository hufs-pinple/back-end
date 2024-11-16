package com.hufs.module.account.repos;

import com.hufs.module.account.entities.Account;

public interface AccountRepositoryExtension {

    Account fetchAccountBy(Long id);
}
