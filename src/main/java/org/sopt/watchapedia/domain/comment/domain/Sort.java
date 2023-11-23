package org.sopt.watchapedia.domain.comment.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Sort {
    DEFAULT("default", null),
    LIKE("like", "likeCount"),
    COMMENT("comment", "commentCount");

    private final String name;
    private final String column;

    public boolean equals(String sort) {
        return name.equals(sort);
    }
}
