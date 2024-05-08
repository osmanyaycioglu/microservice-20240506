package org.training.microservice.msorder.services;

import org.training.microservice.msorder.rest.models.Order;

public interface IOrderManagementService {
    String place(Order orderParam);
}
