package com.hufs.module.place.repos;

import com.hufs.module.place.entities.PlaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceUserRepository extends JpaRepository<PlaceUser,Long>, PlaceUserRepositoryExtension {
}
