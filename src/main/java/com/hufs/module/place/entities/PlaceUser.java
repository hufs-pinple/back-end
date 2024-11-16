package com.hufs.module.place.entities;

import com.hufs.module.place.dtos.PlaceRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "place_user")
public class PlaceUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long placeId;
    private Long accountId;

    public static PlaceUser persist(PlaceRequestDTO.VisitPlace request){
        return PlaceUser.builder()
                .placeId(request.getPlaceId())
                .accountId(request.getAccountId())
                .build();
    }
}
