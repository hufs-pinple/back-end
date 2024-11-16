package com.hufs.module.place.repos;

import com.hufs.module.place.entities.PlaceUser;

public interface PlaceUserRepositoryExtension {

    PlaceUser fetchPlaceUserBy(Long placeId, Long accountId);
}
