package com.hufs.module.place.repos;

import com.hufs.module.place.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long>, PlaceRepositoryExtension{
}
