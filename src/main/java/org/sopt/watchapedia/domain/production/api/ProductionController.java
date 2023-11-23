package org.sopt.watchapedia.domain.production.api;

import lombok.RequiredArgsConstructor;
import org.sopt.watchapedia.domain.production.dto.response.ProductionGetResponse;
import org.sopt.watchapedia.domain.production.service.ProductionService;
import org.sopt.watchapedia.global.common.ApiResponse;
import org.sopt.watchapedia.global.common.SuccessStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
