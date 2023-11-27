package org.sopt.watchapedia.domain.collection.api;

import lombok.RequiredArgsConstructor;
import org.sopt.watchapedia.domain.collection.dto.request.ReplyDeleteRequest;
import org.sopt.watchapedia.domain.collection.dto.request.ReplySaveRequest;
import org.sopt.watchapedia.domain.collection.dto.response.CollectionGetResponse;
import org.sopt.watchapedia.domain.collection.service.CollectionService;
import org.sopt.watchapedia.domain.collection.service.ReplyService;
import org.sopt.watchapedia.global.common.ApiResponse;
import org.sopt.watchapedia.global.common.SuccessStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/collection")
@Controller
public class CollectionApiController {
    private final CollectionService collectionService;
    private final ReplyService replyService;

    @GetMapping("/{collectionId}")
    public ResponseEntity<ApiResponse<?>> getCollection(@PathVariable final Long collectionId) {
        final CollectionGetResponse collection = collectionService.getCollection(collectionId);
        return ApiResponse.success(SuccessStatus.OK, collection);
    }

    @PostMapping("/{collectionId}")
    public ResponseEntity<ApiResponse<?>> saveReply(@PathVariable final Long collectionId,
                                                    @RequestBody final ReplySaveRequest replySaveRequest) {
        replyService.saveReply(collectionId, replySaveRequest);
        return ApiResponse.success(SuccessStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<?>> deleteReply(@RequestBody final ReplyDeleteRequest replyDeleteRequest) {
        replyService.deleteReply(replyDeleteRequest);
        return ApiResponse.success(SuccessStatus.OK);
    }
}
