package com.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="inventory_items")
public class Inventory {

	@Id
	@Column(name="inventory_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;
	@Column(name="sku_code")
	private String skuCode;
	private Integer quantity;
	
	
}
