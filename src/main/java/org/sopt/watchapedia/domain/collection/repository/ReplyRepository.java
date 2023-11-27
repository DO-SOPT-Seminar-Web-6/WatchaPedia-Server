package org.sopt.watchapedia.domain.collection.repository;

import org.sopt.watchapedia.domain.collection.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
