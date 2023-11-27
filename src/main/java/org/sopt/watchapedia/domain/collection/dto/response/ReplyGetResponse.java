package org.sopt.watchapedia.domain.collection.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.sopt.watchapedia.domain.collection.domain.Reply;

@Builder(access = AccessLevel.PRIVATE)
public record ReplyGetResponse(
        Long replyId,
        String content,
        int likeCount
) {
    public static ReplyGetResponse of(Reply reply) {
        return ReplyGetResponse.builder()
                .replyId(reply.getId())
                .content(reply.getContent())
                .likeCount(reply.getLikeCount())
                .build();
    }
}
