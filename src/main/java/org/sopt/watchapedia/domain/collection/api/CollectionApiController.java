package org.sopt.watchapedia.domain.collection.api;

import lombok.RequiredArgsConstructor;
import org.sopt.watchapedia.domain.collection.dto.response.CollectionGetResponse;
import org.sopt.watchapedia.domain.collection.service.CollectionService;
import org.sopt.watchapedia.global.common.ApiResponse;
import org.sopt.watchapedia.global.common.SuccessStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/api/collection")
@Controller
public class CollectionApiController {
    private final CollectionService collectionService;

    @GetMapping("/{collectionId}")
    public ResponseEntity<ApiResponse<?>> getCollection(@PathVariable final Long collectionId) {
        final CollectionGetResponse collection = collectionService.getCollection(collectionId);
        return ApiResponse.success(SuccessStatus.OK, collection);
    }
}
