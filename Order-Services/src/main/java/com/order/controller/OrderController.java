package com.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.Dto.OrderResponseDto;
import com.order.Dto.PlaceOrderRequestDto;
import com.order.entity.Order;
import com.order.services.OrderServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

	private final OrderServices orderServices;

	@PostMapping("/place")
	private final ResponseEntity<?> placeOrder(@RequestBody List<PlaceOrderRequestDto> customerOrders) {
		Order isOrderPlaced = orderServices.placeOrder(customerOrders);

		Map<String, Object> messsage = new HashMap<String, Object>();
		messsage.put("product", isOrderPlaced);
		messsage.put("success", "Successfully Created");
		return (isOrderPlaced != null) ? new ResponseEntity<Map<String, Object>>(messsage, HttpStatus.CREATED)
				: new ResponseEntity<Integer>(HttpStatus.CREATED);

	}

	@GetMapping("/over-all")
	private final ResponseEntity<?> listOfOrder() {
		return new ResponseEntity<List<Order>>(orderServices.listOfOrders(), HttpStatus.CREATED);
	}

}
