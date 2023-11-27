package org.sopt.watchapedia.domain.collection.dto.request;

public record ReplySaveRequest(
        Long userId,
        String content
) {
}
