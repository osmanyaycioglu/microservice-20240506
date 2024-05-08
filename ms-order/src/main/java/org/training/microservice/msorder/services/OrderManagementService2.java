package org.training.microservice.msorder.services;

import org.training.microservice.msorder.rest.models.Order;


public class OrderManagementService2 implements IOrderManagementService{

    @Override
    public String place(final Order orderParam) {
        return "abc";
    }

    @Override
    public String place2(final Order orderParam) {
        return null;
    }

    @Override
    public String place3(final Order orderParam) {
        return null;
    }
}
