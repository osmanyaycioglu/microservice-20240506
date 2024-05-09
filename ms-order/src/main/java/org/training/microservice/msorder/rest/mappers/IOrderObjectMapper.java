package org.training.microservice.msorder.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.training.microservice.msorder.rest.models.MealDto;
import org.training.microservice.msorder.rest.models.OrderDto;
import org.training.microservice.msorder.services.models.Meal;
import org.training.microservice.msorder.services.models.Order;

import java.util.List;

@Mapper()
public interface IOrderObjectMapper {

    IOrderObjectMapper MAPPER = Mappers.getMapper(IOrderObjectMapper.class);

    @Mapping(source = "name",target = "firstName")
    @Mapping(source = "surname",target = "lastname")
    Order toOrder(OrderDto order);

    @Mapping(target = "name",source = "firstName")
    @Mapping(target = "surname",source = "lastname")
    OrderDto toOrder(Order order);

    Meal toMeal(MealDto meal);

    MealDto toMealDto(Meal meal);


    List<Meal> toMeals(List<MealDto> meal);

    List<MealDto> toMealDtos(List<Meal> meal);



}
