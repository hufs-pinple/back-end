package com.hufs.module.account.repos;

import com.hufs.module.account.entities.Account;
import com.hufs.module.account.entities.QAccount;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sun.jdi.request.InvalidRequestStateException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepositoryExtension{
    private final JPAQueryFactory queryFactory;


    @Override
    public Account fetchAccountBy(Long id) {
        return Optional.ofNullable(queryFactory
                .select(QAccount.account)
                .from(QAccount.account)
                .where(QAccount.account.id.eq(id))
                .fetchOne()).orElseThrow(()-> new InvalidRequestStateException("존재하지 않는 유저입니다."));
    }
}
