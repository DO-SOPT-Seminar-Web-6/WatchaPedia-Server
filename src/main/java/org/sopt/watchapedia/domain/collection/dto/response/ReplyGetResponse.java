package org.sopt.watchapedia.domain.collection.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.sopt.watchapedia.domain.collection.domain.Reply;

@Builder(access = AccessLevel.PRIVATE)
public record ReplyGetResponse(
        String content,
        int likeCount
) {
    public static ReplyGetResponse of(Reply reply) {
        return ReplyGetResponse.builder()
                .content(reply.getContent())
                .likeCount(reply.getLikeCount())
                .build();
    }
}
