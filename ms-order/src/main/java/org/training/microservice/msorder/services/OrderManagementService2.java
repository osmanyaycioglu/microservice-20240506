package org.training.microservice.msorder.services;

import org.training.microservice.msorder.rest.models.OrderDto;
import org.training.microservice.msorder.services.models.Order;


public class OrderManagementService2 implements IOrderManagementService{

    @Override
    public String place(final Order orderDtoParam) {
        return "abc";
    }

    @Override
    public String place2(final Order orderDtoParam) {
        return null;
    }

    @Override
    public String place3(final Order orderDtoParam) {
        return null;
    }
}
