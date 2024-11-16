package com.hufs.module.place.repos;

import com.hufs.module.place.dtos.PlaceResponseDTO;
import com.hufs.module.place.entities.Place;
import com.hufs.module.place.entities.QPlace;
import com.hufs.module.place.entities.QPlaceUser;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlaceRepositoryImpl implements PlaceRepositoryExtension{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<PlaceResponseDTO.PlaceOverview> fetchPlaceOverviewBy(Long id) {
        return queryFactory
                .select(Projections.constructor(PlaceResponseDTO.PlaceOverview.class,
                        QPlace.place.id,
                        QPlace.place.latitude,
                        QPlace.place.longitude,
                        QPlace.place.point,
                        JPAExpressions.select(
                                QPlaceUser.placeUser.id.isNotNull()
                        )
                                .from(QPlaceUser.placeUser)
                                .where(QPlaceUser.placeUser.accountId.eq(id),
                                        QPlaceUser.placeUser.placeId.eq(QPlace.place.id))))
                .from(QPlace.place)
                .fetch();
    }

    @Override
    public Place fetchPlaceBy(Long id) {
        return queryFactory
                .select(QPlace.place)
                .from(QPlace.place)
                .where(QPlace.place.id.eq(id))
                .fetchOne();
    }


}
