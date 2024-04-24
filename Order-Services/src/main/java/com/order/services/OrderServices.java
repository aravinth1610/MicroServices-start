package com.order.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.order.Dto.OrderResponseDto;
import com.order.Dto.PlaceOrderRequestDto;
import com.order.entity.Order;
import com.order.entity.OrderLineItems;
import com.order.repository.OrderRepository;
import com.order.repositoryResponseDto.ListOrders;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServices {

	private final OrderRepository orderRepo;

	public Order placeOrder(List<PlaceOrderRequestDto> customerOrders) {
		Order order = new Order();

		order.setOrderNo(UUID.randomUUID().toString().substring(0, 6));

		List<OrderLineItems> orderItems = customerOrders.stream().map(customerOrder -> {
			OrderLineItems orderItem = new OrderLineItems();
			BeanUtils.copyProperties(customerOrder, orderItem);
			orderItem.setOrderItem(order);
			return orderItem;
		}).collect(Collectors.toList());

		order.setOrderLineItems(orderItems);

		return orderRepo.save(order);

	}

//	public List<OrderResponseDto> listOfOrders() {
//		List<ListOrders> listOrders = orderRepo.ListOfOrder();
//
//		return listOrders.stream().map(order -> {
//			OrderResponseDto orderResponse = new OrderResponseDto();
//			BeanUtils.copyProperties(order, orderResponse);
//			return orderResponse;
//		}).collect(Collectors.toList());
//
//	}
	
	public List<Order> listOfOrders(){
		return orderRepo.findAll();
	}

}
