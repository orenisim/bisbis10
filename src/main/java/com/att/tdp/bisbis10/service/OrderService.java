package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.OrderItemRequestBodyDto;
import com.att.tdp.bisbis10.exception.ValidationException;
import com.att.tdp.bisbis10.model.*;
import com.att.tdp.bisbis10.repository.OrderItemsRepository;
import com.att.tdp.bisbis10.repository.OrderRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private OrderItemsRepository orderItemsRepository;



    public UUID placeOrder(Long restaurantId, List<OrderItemRequestBodyDto> orderItems) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();

            // Check if all dish IDs belong to the specified restaurant
            List<Long> dishIds = orderItems.stream().map(OrderItemRequestBodyDto::getDishId).collect(Collectors.toList());
            boolean allDishesBelongToRestaurant = restaurant.getRestaurantDishes().stream()
                    .map(Dish::getDishId)
                    .allMatch(dishIds::contains);

            if (!allDishesBelongToRestaurant) {
                throw new ValidationException("Restaurant does not belong to any dish");
            }


            Order order = new Order();
            order.setRestaurant(restaurant);
            UUID orderId = orderRepository.save(order).getOrderId();
            List<OrderItem> orderItemList = new ArrayList<>();
            for (OrderItemRequestBodyDto orderItem : orderItems) {
                Dish dish = restaurant.getRestaurantDishes().stream()
                        .filter(d -> d.getDishId().equals(orderItem.getDishId()))
                        .findFirst()
                        .orElse(null);
                if(dish != null) {
                    OrderItem newOrderItem = new OrderItem();
                    newOrderItem.setOrder(order);
                    newOrderItem.setAmount(orderItem.getAmount());
                    newOrderItem.setDishId(dish);
                    orderItemList.add(newOrderItem);
                    orderItemsRepository.save(newOrderItem);
                }

            }

            return orderId;
        }
        throw new ValidationException("Restaurant does not belong to any dish");
    }

}


