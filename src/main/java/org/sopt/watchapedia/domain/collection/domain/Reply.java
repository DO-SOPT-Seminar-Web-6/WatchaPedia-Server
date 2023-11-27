package org.sopt.watchapedia.domain.collection.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private int likeCount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collection_id")
    private Collection collection;

    public static Reply createReply(String content, int likeCount, Collection collection) {
        Reply reply = Reply.builder()
                .content(content)
                .likeCount(likeCount)
                .build();
        reply.changeCollection(collection);
        return reply;
    }

    private void changeCollection(Collection collection) {
        if (this.collection != null) {
            this.collection.removeReply(this);
        }
        collection.addReply(this);
        this.collection = collection;
    }
}
