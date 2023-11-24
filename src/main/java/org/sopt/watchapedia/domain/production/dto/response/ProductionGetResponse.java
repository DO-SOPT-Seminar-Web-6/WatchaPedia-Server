package org.sopt.watchapedia.domain.production.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.sopt.watchapedia.domain.production.domain.Production;


@Builder(access = AccessLevel.PRIVATE)
public record ProductionGetResponse(
        Long id,
        String imageUrl,
        String name,
        String role,
        String roleDetail
) {
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
