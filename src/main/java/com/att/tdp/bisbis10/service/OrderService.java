package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.OrderItemDto;
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

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private OrderItemsRepository orderItemsRepository;


    public UUID placeOrder(Long restaurantId, List<OrderItemDto> orderItems) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();

            // Create a new Rating entity
            Order order = new Order();
            order.setRestaurant(restaurant);
            UUID orderId = orderRepository.save(order).getOrderId();
            List<OrderItem> orderItemList = new ArrayList<>();
            for (OrderItemDto orderItem : orderItems) {
                Dish dish = restaurant.getRestaurantDishes().stream()
                        .filter(d -> d.getDishId().equals(orderItem.getDishId()))
                        .findFirst()
                        .orElse(null);
                if(dish != null) {
                    OrderItem orderItem1 = new OrderItem();
                    orderItem1.setOrder(order);
                    orderItem1.setAmount(orderItem.getAmount());
                    orderItem1.setDishId(dish);
                    orderItemList.add(orderItem1);
                    orderItemsRepository.save(orderItem1);
                }

            }

            return orderId;
        }
        return null;
    }

}


