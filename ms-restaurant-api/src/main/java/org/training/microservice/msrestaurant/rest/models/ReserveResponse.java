package org.training.microservice.msrestaurant.rest.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReserveResponse {
    private String desc;
    private Integer estimatedTime;

    @Builder(setterPrefix = "with")
    public ReserveResponse(final String descParam,
                           final Integer estimatedTimeParam) {
        desc          = descParam;
        estimatedTime = estimatedTimeParam;
    }
}
