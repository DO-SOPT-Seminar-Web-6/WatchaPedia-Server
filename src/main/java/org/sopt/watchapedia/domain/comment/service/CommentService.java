package org.sopt.watchapedia.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.sopt.watchapedia.domain.comment.domain.Comment;
import org.sopt.watchapedia.domain.comment.dto.response.CommentGetResponse;
import org.sopt.watchapedia.domain.comment.repository.CommentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.sopt.watchapedia.domain.comment.domain.Sort.*;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CommentService {
    private final CommentValidator commentValidator;
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;

    public List<CommentGetResponse> getComments(String sort) {
        commentValidator.validateCommentSortCriteria(sort);
        List<Comment> comments = getCommentsAccordingToSortCriteria(sort);
        return commentMapper.commentsToCommentGetResponses(comments);
    }

    private List<Comment> getCommentsAccordingToSortCriteria(String sort) {
        if (DEFAULT.equals(sort)) {
            return commentRepository.findAll();
        } else if (LIKE.equals(sort)) {
            return commentRepository.findAll(Sort.by(Sort.Direction.DESC, LIKE.getColumn()));
        }
        return commentRepository.findAll(Sort.by(Sort.Direction.DESC, COMMENT.getColumn()));
    }
}
