package org.training.microservice.msorder.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.training.microservice.msorder.integration.notification.NotificationIntegration;
import org.training.microservice.msorder.integration.restaurant.RestaurantReserveIntegration;
import org.training.microservice.msorder.services.models.Order;
import org.training.microservice.msrestaurant.rest.models.ReserveResponse;


@RequiredArgsConstructor
public class OrderManagementService implements IOrderManagementService{
    private final RestaurantReserveIntegration restaurantReserveIntegration;
    @Autowired
    private NotificationIntegration notificationIntegration;

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
        notificationIntegration.sendMessage(reserveLoc.getDesc(),orderDtoParam.getPhone());
        return reserveLoc.getDesc();
    }
}
