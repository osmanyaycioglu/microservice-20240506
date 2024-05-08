package org.training.microservice.msorder.rest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String name;
    private String surname;
    private String phone;
    private String address;
    private List<Meal> meals;


}
