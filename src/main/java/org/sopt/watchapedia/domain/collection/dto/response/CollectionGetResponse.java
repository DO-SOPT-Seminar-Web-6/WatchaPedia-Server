package org.sopt.watchapedia.domain.collection.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.sopt.watchapedia.domain.collection.domain.Collection;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record CollectionGetResponse(
        String title,
        int replyCount,
        List<ReplyGetResponse> replies
) {
    public static CollectionGetResponse of(Collection collection, List<ReplyGetResponse> replies) {
        return CollectionGetResponse.builder()
                .title(collection.getTitle())
                .replyCount(replies.size())
                .replies(replies)
                .build();
    }
}
