package org.training.microservice.msorder.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.microservice.msorder.integration.restaurant.RestaurantReserveIntegration;
import org.training.microservice.msorder.rest.models.Order;
import org.training.microservice.msrestaurant.rest.models.ReserveResponse;


@RequiredArgsConstructor
public class OrderManagementService implements IOrderManagementService{
    private final RestaurantReserveIntegration restaurantReserveIntegration;

    @Override
    public String place(final Order orderParam) {
        ReserveResponse reserveLoc = restaurantReserveIntegration.reserve(orderParam);
        return reserveLoc.getDesc();
    }

    @Override
    public String place2(final Order orderParam) {
        ReserveResponse reserveLoc = restaurantReserveIntegration.reserve2(orderParam);
        return reserveLoc.getDesc();
    }

    @Override
    public String place3(final Order orderParam) {
        ReserveResponse reserveLoc = restaurantReserveIntegration.reserve3(orderParam);
        return reserveLoc.getDesc();
    }
}
