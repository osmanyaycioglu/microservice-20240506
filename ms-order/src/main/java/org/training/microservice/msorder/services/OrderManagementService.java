package org.training.microservice.msorder.services;

import lombok.RequiredArgsConstructor;
import org.training.microservice.msorder.integration.restaurant.RestaurantReserveIntegration;
import org.training.microservice.msorder.services.models.Order;
import org.training.microservice.msrestaurant.rest.models.ReserveResponse;


@RequiredArgsConstructor
public class OrderManagementService implements IOrderManagementService{
    private final RestaurantReserveIntegration restaurantReserveIntegration;

    @Override
    public String place(final Order orderDtoParam) {
        ReserveResponse reserveLoc = restaurantReserveIntegration.reserve(orderDtoParam);
        return reserveLoc.getDesc();
    }

    @Override
    public String place2(final Order orderDtoParam) {
        ReserveResponse reserveLoc = restaurantReserveIntegration.reserve2(orderDtoParam);
        return reserveLoc.getDesc();
    }

    @Override
    public String place3(final Order orderDtoParam) {
        ReserveResponse reserveLoc = restaurantReserveIntegration.reserve3(orderDtoParam);
        return reserveLoc.getDesc();
    }
}
