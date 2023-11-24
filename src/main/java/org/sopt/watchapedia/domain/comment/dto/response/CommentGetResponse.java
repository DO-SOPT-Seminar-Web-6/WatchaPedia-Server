package org.sopt.watchapedia.domain.comment.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.sopt.watchapedia.domain.comment.domain.Comment;

@Builder(access = AccessLevel.PRIVATE)
public record CommentGetResponse(
        String imageUrl,
        String name,
        int star,
        String content,
        int likeCount,
        int commentCount,
        boolean isLike
) {
    public static CommentGetResponse of(Comment comment) {
        return CommentGetResponse.builder()
                .imageUrl(comment.getImageUrl())
                .name(comment.getName())
                .star(comment.getStar())
                .content(comment.getContent())
                .likeCount(comment.getLikeCount())
                .commentCount(comment.getCommentCount())
                .isLike(comment.isLike())
                .build();
    }
}
