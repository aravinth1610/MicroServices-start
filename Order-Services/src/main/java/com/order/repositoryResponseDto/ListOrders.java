package com.order.repositoryResponseDto;

import java.math.BigDecimal;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListOrders {

	private String orderNo;
	private String name;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;

}
