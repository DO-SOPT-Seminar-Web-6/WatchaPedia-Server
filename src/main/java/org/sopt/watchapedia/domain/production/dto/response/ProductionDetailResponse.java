package org.sopt.watchapedia.domain.production.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.sopt.watchapedia.domain.production.domain.Production;
import org.w3c.dom.Text;

@Getter
@Builder
public class ProductionDetailResponse {
    private String imageUrl;
    private String name;
    private String role;
    private String biography;

    public static ProductionDetailResponse of(Production production) {
        return ProductionDetailResponse.builder()
                .imageUrl(production.getImageUrl())
                .name(production.getName())
                .role(production.getRole())
                .biography(production.getBiography())
                .build();
    }
}
