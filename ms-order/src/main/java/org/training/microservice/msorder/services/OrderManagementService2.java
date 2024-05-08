package org.training.microservice.msorder.services;

import org.training.microservice.msorder.rest.models.Order;


public class OrderManagementService2 implements IOrderManagementService{

    @Override
    public String place(final Order orderParam) {
        return "abc";
    }
}
