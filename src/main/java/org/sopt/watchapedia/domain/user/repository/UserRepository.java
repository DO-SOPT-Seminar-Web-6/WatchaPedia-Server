package org.sopt.watchapedia.domain.user.repository;

import org.sopt.watchapedia.domain.user.domain.User;
import org.sopt.watchapedia.global.error.BusinessException;
import org.sopt.watchapedia.global.error.ErrorStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    default User findByIdOrThrow(Long userId) {
        return findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorStatus.ENTITY_NOT_FOUND));
    }
}
