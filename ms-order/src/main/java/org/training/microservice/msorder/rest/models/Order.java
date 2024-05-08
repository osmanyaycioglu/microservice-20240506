package org.training.microservice.msorder.rest.models;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @NotBlank
    @Size(min = 2,max = 20)
    private String name;
    @NotEmpty
    private String surname;
    private String phone;
    private String address;
    @NotNull
    private List<Meal> meals;
    @Future
    private LocalDateTime dueTime;

    @Positive
    @Min(1)
    @Max(100)
    private Integer count;


}
