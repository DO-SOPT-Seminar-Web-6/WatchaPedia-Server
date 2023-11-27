package org.sopt.watchapedia.domain.collection.repository;

import org.sopt.watchapedia.domain.collection.domain.Collection;
import org.sopt.watchapedia.global.error.BusinessException;
import org.sopt.watchapedia.global.error.ErrorStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, Long> {
    default Collection findByIdOrThrow(Long collectionId) {
        return findById(collectionId)
                .orElseThrow(() -> new BusinessException(ErrorStatus.ENTITY_NOT_FOUND));
    }
}
