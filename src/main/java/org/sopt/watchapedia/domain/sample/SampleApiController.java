package org.sopt.watchapedia.domain.sample;

import org.sopt.watchapedia.global.common.ApiResponse;
import org.sopt.watchapedia.global.common.SuccessStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sample")
@Controller
public class SampleApiController {
    @GetMapping
    public ResponseEntity<ApiResponse<?>> sample() {
        return ApiResponse.success(SuccessStatus.OK);
    }
}
