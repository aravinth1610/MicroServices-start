package com.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.entity.Order;
import com.order.repositoryResponseDto.ListOrders;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

//	@Query("SELECT new com.order.repositoryResponseDto.ListOrders(u.orderNo,v.name,v.skuCode,v.price,v.quantity) FROM Order u JOIN OrderLineItems v ON u.orderNo=v.order")
//	List<ListOrders> ListOfOrder();
//	
}
