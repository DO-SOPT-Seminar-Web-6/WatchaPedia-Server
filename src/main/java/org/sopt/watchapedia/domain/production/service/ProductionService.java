package org.sopt.watchapedia.domain.production.service;

import lombok.RequiredArgsConstructor;
import org.sopt.watchapedia.domain.production.dto.response.ProductionDetailResponse;
import org.sopt.watchapedia.domain.production.dto.response.ProductionGetResponse;
import org.sopt.watchapedia.domain.production.repository.ProductionRepository;
import org.sopt.watchapedia.global.error.BusinessException;
import org.sopt.watchapedia.global.error.ErrorStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductionService {
    public final ProductionRepository productionRepository;

    public List<ProductionGetResponse> getProductions() {
        return productionRepository.findAll().stream()
                .map(ProductionGetResponse::of)
                .toList();
    }

    public ProductionDetailResponse getProductionDetail(final Long productionId) {
        return productionRepository.findById(productionId)
                .map(ProductionDetailResponse::of)
                .orElseThrow(() -> new BusinessException(ErrorStatus.ENTITY_NOT_FOUND));
    }
}
