package org.sopt.watchapedia.domain.comment.repository;

import org.sopt.watchapedia.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
