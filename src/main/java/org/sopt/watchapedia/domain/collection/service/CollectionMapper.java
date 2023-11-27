package org.sopt.watchapedia.domain.collection.service;

import org.sopt.watchapedia.domain.collection.domain.Collection;
import org.sopt.watchapedia.domain.collection.domain.Reply;
import org.sopt.watchapedia.domain.collection.dto.response.CollectionGetResponse;
import org.sopt.watchapedia.domain.collection.dto.response.ReplyGetResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollectionMapper {
    public CollectionGetResponse collectionToCollectionGetResponse(Collection collection) {
        List<Reply> replies = collection.getReplies();
        List<ReplyGetResponse> replyGetResponses = replies.stream()
                .map(ReplyGetResponse::of)
                .toList();
        return CollectionGetResponse.of(collection, replyGetResponses);
    }
}
