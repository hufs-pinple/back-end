package com.hufs.module.place.controllers;


import com.hufs.module.place.dtos.PlaceRequestDTO;
import com.hufs.module.place.services.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {
    private final PlaceService service;

    @GetMapping
    public ResponseEntity<?> fetchPlaceOverview(
            @RequestParam Long accountId
    ) {
        return service.fetchPlaceOverview(accountId);
    }

    @GetMapping("/{placeId}")
    public ResponseEntity<?> fetchPlaceDetail(
            @PathVariable Long placeId,
            @RequestParam Long accountId
    ) {
        return service.fetchPlaceDetail(placeId);
    }

    @PostMapping
    public ResponseEntity<?> visitPlace(
            @RequestBody PlaceRequestDTO.VisitPlace request
    ) {
        return service.visitPlace(request);
    }
}
