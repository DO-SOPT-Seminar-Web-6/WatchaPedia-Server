package org.sopt.watchapedia.domain.comment.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    @Column(nullable = false)
    private String imageUrl;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int star;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private int likeCount;
    @Column(nullable = false)
    private int commentCount;
    @Column(nullable = false)
    private boolean isLike;
}
