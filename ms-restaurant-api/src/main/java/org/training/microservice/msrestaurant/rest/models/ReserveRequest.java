package org.training.microservice.msrestaurant.rest.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ReserveRequest {
    private List<Meal> meals;
    private Integer dueTime;
    private String customerId;

    @Builder(setterPrefix = "with")
    public ReserveRequest(final List<Meal> mealsParam,
                          final Integer dueTimeParam,
                          final String customerIdParam) {
        meals      = mealsParam;
        dueTime    = dueTimeParam;
        customerId = customerIdParam;
    }
}
