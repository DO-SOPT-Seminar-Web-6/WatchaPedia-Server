package org.sopt.watchapedia.domain.production.api;

import lombok.RequiredArgsConstructor;
import org.sopt.watchapedia.domain.production.dto.response.ProductionDetailResponse;
import org.sopt.watchapedia.domain.production.dto.response.ProductionGetResponse;
import org.sopt.watchapedia.domain.production.service.ProductionService;
import org.sopt.watchapedia.global.common.ApiResponse;
import org.sopt.watchapedia.global.common.SuccessStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ProductionController {

    private final ProductionService productionService;

    @GetMapping("/production")
    public ResponseEntity<ApiResponse<?>> getProductions() {
        List<ProductionGetResponse> productions = productionService.getProductions();
        return ApiResponse.success(SuccessStatus.OK, productions);
    }

    @GetMapping("/production/{productionId}")
    public ResponseEntity<ApiResponse<?>> getProductionDetail(@PathVariable final Long productionId) {
        ProductionDetailResponse productionDetail = productionService.getProductionDetail(productionId);
        return ApiResponse.success(SuccessStatus.OK, productionDetail);
    }

}
