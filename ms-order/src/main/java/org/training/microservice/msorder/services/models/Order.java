package org.training.microservice.msorder.services.models;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training.microservice.msorder.rest.models.MealDto;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String        firstName;
    private String        lastname;
    private String        phone;
    private String        address;
    private List<Meal>    meals;
    private LocalDateTime dueTime;
    private Integer       count;

    private EOrderStatus orderStatus;

}
