package com.hufs.module.place.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PlaceRequestDTO {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class VisitPlace{
        private Long placeId;
        private Long accountId;
        private String code;


    }
}
