package com.hufs.module.place.services;

import com.hufs.global.dtos.CollectionDTO;
import com.hufs.global.dtos.GlobalResponseDTO;
import com.hufs.module.account.entities.Account;
import com.hufs.module.account.repos.AccountRepository;
import com.hufs.module.account.repos.AccountRepositoryExtension;
import com.hufs.module.place.dtos.PlaceRequestDTO;
import com.hufs.module.place.dtos.PlaceResponseDTO;
import com.hufs.module.place.entities.Place;
import com.hufs.module.place.entities.PlaceUser;
import com.hufs.module.place.repos.PlaceRepository;
import com.hufs.module.place.repos.PlaceUserRepository;
import com.sun.jdi.request.InvalidRequestStateException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final PlaceUserRepository placeUserRepository;
    private final AccountRepository accountRepository;

    public ResponseEntity<?> fetchPlaceOverview(Long accountId) {
        List<PlaceResponseDTO.PlaceOverview> records = placeRepository.fetchPlaceOverviewBy(accountId);

        return ResponseEntity
                .ok(CollectionDTO.BasicResponse.map(records));
    }

    public ResponseEntity<?> fetchPlaceDetail(Long placeId) {
        Place place = placeRepository.fetchPlaceBy(placeId);

        return ResponseEntity
                .ok(PlaceResponseDTO.PlaceDetail.of(place));
    }

    public ResponseEntity<?> visitPlace(PlaceRequestDTO.VisitPlace request) {
        Place place = placeRepository.fetchPlaceBy(request.getPlaceId());
        PlaceUser placeUser = placeUserRepository.fetchPlaceUserBy(request.getPlaceId(), request.getAccountId());
        Account account  = accountRepository.fetchAccountBy(request.getAccountId());

        validateCode(place, request.getCode());
        validateUser(placeUser);

        place.visitPlace();
        account.visitPlace();
        placeUserRepository.save(PlaceUser.persist(request));

        return ResponseEntity
                .ok(GlobalResponseDTO.BasicResponse.of(true, "Successfully completed request"));
    }

    private void validateCode(Place place, String code) {
        if (!place.getCode().equals(code)) throw new InvalidRequestStateException("등록되지 않은 코드입니다.");
    }

    private void validateUser(PlaceUser placeUser) {
        if (Objects.nonNull(placeUser)) throw new InvalidRequestStateException("이미 방문한 장소입니다.");
    }
}
