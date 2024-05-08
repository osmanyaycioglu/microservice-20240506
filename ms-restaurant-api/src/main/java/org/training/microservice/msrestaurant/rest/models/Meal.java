package org.training.microservice.msrestaurant.rest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Meal {
    private String meal;
    private Double amount;

    @Builder(setterPrefix = "with")
    public Meal(final String mealParam,
                final Double amountParam) {
        meal   = mealParam;
        amount = amountParam;
    }
}
