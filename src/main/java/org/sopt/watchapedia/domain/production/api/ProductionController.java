package org.sopt.watchapedia.domain.production.api;

import lombok.RequiredArgsConstructor;
import org.sopt.watchapedia.domain.production.dto.response.ProductionDetailResponse;
import org.sopt.watchapedia.domain.production.dto.response.ProductionGetResponse;
import org.sopt.watchapedia.domain.production.service.ProductionService;
import org.sopt.watchapedia.global.common.ApiResponse;
import org.sopt.watchapedia.global.common.SuccessStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/production")
@Controller
@RequiredArgsConstructor
public class ProductionController {
    private final ProductionService productionService;
    @GetMapping
    public ResponseEntity<ApiResponse<?>> getProductions() {
        List<ProductionGetResponse> productions = productionService.getProductions();
        return ApiResponse.success(SuccessStatus.OK, productions);
    }

    @GetMapping("/{productionId}")
    public ResponseEntity<ApiResponse<?>> getProductionDetail(@PathVariable final Long productionId) {
        final ProductionDetailResponse productionDetail = productionService.getProductionDetail(productionId);
        return ApiResponse.success(SuccessStatus.OK, productionDetail);
    }
}
