package org.sopt.watchapedia.domain.collection.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.watchapedia.domain.collection.domain.Collection;
import org.sopt.watchapedia.domain.collection.dto.response.CollectionGetResponse;
import org.sopt.watchapedia.domain.collection.repository.CollectionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Transactional
@Service
public class CollectionService {
    private final CollectionMapper collectionMapper;
    private final CollectionRepository collectionRepository;

    public CollectionGetResponse getCollection(Long collectionId) {
        Collection findCollection = collectionRepository.findByIdOrThrow(collectionId);
        log.info("test: {}", findCollection);
        return collectionMapper.collectionToCollectionGetResponse(findCollection);
    }
}
