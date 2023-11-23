package org.sopt.watchapedia.domain.production.dto.response;

import lombok.*;
import org.sopt.watchapedia.domain.production.domain.Production;


@Getter
@Builder
public class ProductionGetResponse {
        private Long id;
        private String imageUrl;
        private String name;
        private String role;
        private String roleDetail;


        public static ProductionGetResponse of(Production production) {
                return ProductionGetResponse.builder()
                        .id(production.getId())
                        .imageUrl(production.getImageUrl())
                        .name(production.getName())
                        .role(production.getRole())
                        .roleDetail(production.getRoleDetail())
                        .build();
        }
}

