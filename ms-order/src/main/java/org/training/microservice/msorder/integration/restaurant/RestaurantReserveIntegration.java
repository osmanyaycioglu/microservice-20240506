package org.training.microservice.msorder.integration.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.training.microservice.msorder.rest.models.Order;
import org.training.microservice.msrestaurant.rest.models.Meal;
import org.training.microservice.msrestaurant.rest.models.ReserveRequest;
import org.training.microservice.msrestaurant.rest.models.ReserveResponse;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantReserveIntegration {
    private final RestTemplate restTemplate;

    public ReserveResponse reserve(Order orderParam) {

        ReserveRequest reserveRequestLoc = ReserveRequest.builder()
                                                         .withCustomerIdParam("asdgfdsf")
                                                         .withDueTimeParam(30)
                                                         .withMealsParam(orderParam.getMeals()
                                                                                   .stream()
                                                                                   .map(m -> Meal.builder()
                                                                                                 .withMealParam(m.getMealName())
                                                                                                 .withAmountParam(m.getAmount())
                                                                                                 .build())
                                                                                   .collect(Collectors.toList()))
                                                         .build();
        return restTemplate.postForObject("http://RESTAURANT/api/v1/cook/management/reserve",
                                          reserveRequestLoc,
                                          ReserveResponse.class);
    }

}
