package org.sopt.watchapedia.domain.comment.service;

import org.sopt.watchapedia.domain.comment.domain.Comment;
import org.sopt.watchapedia.domain.comment.dto.response.CommentGetResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentMapper {
    public List<CommentGetResponse> commentsToCommentGetResponses(List<Comment> comments) {
        return comments.stream()
                .map(CommentGetResponse::of)
                .toList();
    }
}
