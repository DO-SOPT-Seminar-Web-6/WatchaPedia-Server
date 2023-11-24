package org.sopt.watchapedia.domain.production.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.sopt.watchapedia.domain.production.domain.Production;

@Builder(access = AccessLevel.PRIVATE)
public record ProductionDetailResponse(
        String imageUrl,
        String name,
        String role,
        String biography
) {
    public static ProductionDetailResponse of(Production production) {
        return ProductionDetailResponse.builder()
                .imageUrl(production.getImageUrl())
                .name(production.getName())
                .role(production.getRole())
                .biography(production.getBiography())
                .build();
    }
}
