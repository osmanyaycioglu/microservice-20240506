package org.training.microservice.msorder.services;

import org.training.microservice.msorder.rest.models.OrderDto;
import org.training.microservice.msorder.services.models.Order;

public interface IOrderManagementService {
    String place(Order orderDtoParam);
    String place2(Order orderDtoParam);
    String place3(Order orderDtoParam);
}
