package org.training.microservice.msorder.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training.microservice.msorder.error.ErrorObj;
import org.training.microservice.msorder.rest.models.Order;
import org.training.microservice.msorder.services.IOrderManagementService;
import org.training.microservice.msorder.services.OrderManagementService;

@RestController
@RequestMapping("/api/v1/order/management")
@RequiredArgsConstructor
public class OrderManagementController {
    private final IOrderManagementService orderManagementService;


    @PostMapping("/place")
    public String place(@RequestBody @Valid Order orderParam) {
        return orderManagementService.place(orderParam);
    }

    @PostMapping("/place2")
    public String place2(@RequestBody @Valid Order orderParam) {
        return orderManagementService.place2(orderParam);
    }

    @PostMapping("/place3")
    public String place3(@RequestBody @Valid Order orderParam) {
        return orderManagementService.place3(orderParam);
    }

    @PostMapping("/suspend")
    public void suspend() {
    }



}
