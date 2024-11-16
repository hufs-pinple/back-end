package com.hufs.global.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class GlobalResponseDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BasicResponse {

        private boolean success;
        private String message;

        public static BasicResponse of(boolean isSuccess, String message) {
            return BasicResponse.builder()
                    .success(isSuccess)
                    .message(message)
                    .build();
        }
    }


    /**
     * <h1>☕ BasicErrorResponse</h1>
     *
     * @author Jynn ❖
     * @version 1.0.0
     * @since 2022/08/28
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BasicErrorResponse {

        private boolean success;
        private String message;

        public static BasicErrorResponse of(boolean isSuccess, String message) {
            return BasicErrorResponse.builder()
                    .success(isSuccess)
                    .message(message)
                    .build();
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PopupMessage {

        private boolean success;
        private String title;
        private String message;

        /**
         * <h2>♻ OF</h2>
         * <small>constructors & converters</small>
         *
         * @author Jynn ❖
         * @since 2022/09/14 4:55 PM
         */
        public static PopupMessage of(boolean isSuccess, String title, String message) {
            return PopupMessage.builder()
                    .success(isSuccess)
                    .title(title)
                    .message(message)
                    .build();
        }

    }

}
