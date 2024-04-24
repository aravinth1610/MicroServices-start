package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.OrderLineItems;

@Repository
public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems, Long> {

}
