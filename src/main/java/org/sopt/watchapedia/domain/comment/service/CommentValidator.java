package org.sopt.watchapedia.domain.comment.service;

import org.sopt.watchapedia.domain.comment.domain.Sort;
import org.sopt.watchapedia.global.error.BusinessException;
import org.sopt.watchapedia.global.error.ErrorStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CommentValidator {
    public void validateCommentSortCriteria(String sort) {
        boolean isValid = matchIsValidSortCriteria(sort);
        if (!isValid) {
            throw new BusinessException(ErrorStatus.BAD_REQUEST);
        }
    }

    private boolean matchIsValidSortCriteria(String sort) {
        return Arrays.stream(Sort.values())
                .anyMatch(s -> s.getName().equals(sort));
    }
}
