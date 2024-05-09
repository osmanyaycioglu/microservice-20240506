package org.training.microservice.msorder.rest.models;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealDto {
    private String mealName;
    @DecimalMin("0")
    @DecimalMax("10")
    private Double amount;
}
