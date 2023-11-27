package org.sopt.watchapedia.domain.collection.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collection_id")
    private Long id;
    @Column(nullable = false)
    private String title;
    @OneToMany(mappedBy = "collection", cascade = CascadeType.REMOVE)
    private List<Reply> replies = new ArrayList<>();

    public void addReply(Reply reply) {
        replies.add(reply);
    }

    public void removeReply(Reply reply) {
        replies.remove(reply);
    }
}
