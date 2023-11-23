package org.sopt.watchapedia.domain.comment.api;

import lombok.RequiredArgsConstructor;
import org.sopt.watchapedia.domain.comment.dto.response.CommentGetResponse;
import org.sopt.watchapedia.domain.comment.service.CommentService;
import org.sopt.watchapedia.global.common.ApiResponse;
import org.sopt.watchapedia.global.common.SuccessStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/comment")
@Controller
public class CommentApiController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getComments(@RequestParam String sort) {
        List<CommentGetResponse> comments = commentService.getComments(sort);
        return ApiResponse.success(SuccessStatus.OK, comments);
    }
}
