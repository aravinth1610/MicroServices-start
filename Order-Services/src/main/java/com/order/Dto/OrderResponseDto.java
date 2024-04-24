package com.order.Dto;

import java.math.BigDecimal;
import java.util.List;

import com.order.entity.OrderLineItems;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {

	private String orderNo;
	private String name;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;

}
