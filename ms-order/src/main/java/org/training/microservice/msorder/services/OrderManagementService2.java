package org.training.microservice.msorder.services;

import org.training.microservice.msorder.rest.models.OrderDto;


public class OrderManagementService2 implements IOrderManagementService{

    @Override
    public String place(final OrderDto orderDtoParam) {
        return "abc";
    }

    @Override
    public String place2(final OrderDto orderDtoParam) {
        return null;
    }

    @Override
    public String place3(final OrderDto orderDtoParam) {
        return null;
    }
}
