package org.training.microservice.msorder.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.microservice.msorder.rest.mappers.IOrderObjectMapper;
import org.training.microservice.msorder.rest.models.OrderDto;
import org.training.microservice.msorder.services.IOrderManagementService;
import reactor.netty.http.server.HttpServerRequest;

@RestController
@RequestMapping("/api/v1/order/management")
@RequiredArgsConstructor
public class OrderManagementController {
    private final IOrderManagementService orderManagementService;


    @PostMapping("/place")
    public String place(@RequestBody @Valid OrderDto orderDtoParam) {
        return orderManagementService.place(IOrderObjectMapper.MAPPER.toOrder(orderDtoParam));
    }

    @PostMapping("/place2")
    public String place2(@RequestBody @Valid OrderDto orderDtoParam) {
        return orderManagementService.place2(IOrderObjectMapper.MAPPER.toOrder(orderDtoParam));
    }

    @PostMapping("/place3")
    public String place3(@RequestBody @Valid OrderDto orderDtoParam) {
        return orderManagementService.place3(IOrderObjectMapper.MAPPER.toOrder(orderDtoParam));
    }

    @PostMapping("/suspend")
    public void suspend() {
    }

}
