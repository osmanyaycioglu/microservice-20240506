package org.training.microservice.msorder.services;

import org.training.microservice.msorder.rest.models.Order;

public interface IOrderManagementService {
    String place(Order orderParam);
    String place2(Order orderParam);
    String place3(Order orderParam);
}
