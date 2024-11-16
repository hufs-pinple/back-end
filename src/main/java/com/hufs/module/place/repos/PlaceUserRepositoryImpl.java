package com.hufs.module.place.repos;

import com.hufs.module.place.entities.PlaceUser;
import com.hufs.module.place.entities.QPlaceUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaceUserRepositoryImpl implements PlaceUserRepositoryExtension {
    private final JPAQueryFactory queryFactory;


    @Override
    public PlaceUser fetchPlaceUserBy(Long placeId, Long accountId) {
        return queryFactory
                .select(QPlaceUser.placeUser)
                .from(QPlaceUser.placeUser)
                .where(QPlaceUser.placeUser.accountId.eq(accountId),
                        QPlaceUser.placeUser.placeId.eq(placeId))
                .fetchOne();
    }
}
