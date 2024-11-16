package com.hufs.module.place.dtos;

import com.hufs.module.place.entities.Place;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

public class PlaceResponseDTO {
    @Builder
    @NoArgsConstructor
    @Getter
    public static class PlaceOverview {
        private Long id;
        private String latitude;
        private String longitude;
        private Long scale;
        private Boolean isVisited;

        public PlaceOverview(Long id, String latitude, String longitude, Long scale, Boolean isVisited) {
            scale /= 10;
            this.id = id;
            this.latitude = latitude;
            this.longitude = longitude;
            this.scale = scale > 20 ? scale : 20;
            this.isVisited = Objects.nonNull(isVisited) ? isVisited : false;
        }
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class PlaceDetail {
        private Long id;
        private Long point;
        private String name;
        private String detail;
        private String imageUrl;

        public static PlaceDetail of(Place place) {
            return PlaceDetail.builder()
                    .id(place.getId())
                    .name(place.getName())
                    .detail(place.getDetail())
                    .imageUrl(place.getImageUrl())
                    .point(place.getPoint())
                    .build();
        }
    }
}
