package com.hufs.module.place.repos;

import com.hufs.module.place.dtos.PlaceResponseDTO;
import com.hufs.module.place.entities.Place;

import java.util.List;

public interface PlaceRepositoryExtension {

    List<PlaceResponseDTO.PlaceOverview> fetchPlaceOverviewBy(Long id);
    Place fetchPlaceBy(Long id);
}
