package org.training.microservice.msorder.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.microservice.msorder.rest.models.Order;
import org.training.microservice.msorder.services.IOrderManagementService;
import org.training.microservice.msorder.services.OrderManagementService;

@RestController
@RequestMapping("/api/v1/order/management")
@RequiredArgsConstructor
public class OrderManagementController {
    private final IOrderManagementService orderManagementService;


    @PostMapping("/place")
    public String place(@RequestBody Order orderParam) {
        return orderManagementService.place(orderParam);
    }

    @PostMapping("/place2")
    public void place2() {
    }

    @PostMapping("/suspend")
    public void suspend() {
    }

}
