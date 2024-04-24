package com.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_line_items")
@DynamicInsert
public class OrderLineItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_items_id")
	private Long orderItemsId;
	private String name;
	@Column(name = "sku_code")
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "ordernofk", referencedColumnName = "orderno")
	@JsonIgnore
	private Order orderItem;

}
