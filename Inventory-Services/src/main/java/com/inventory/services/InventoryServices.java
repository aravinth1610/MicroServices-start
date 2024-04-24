package com.inventory.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.entity.Inventory;
import com.inventory.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServices {

	private InventoryRepository inventoryRepo;

	public Boolean isInStock(List<String> skuCode) {

		System.out.println(skuCode);

//		Inventory in = new Inventory();
//		in.setSkuCode("rm-12-max");
//		in.setQuantity(0);
//		in.setSkuCode("rm-1;
//		in.setQuantity(2);
//		inventoryRepo.save(in);

		//boolean isStock = 
				inventoryRepo.findAll();
				//.findBySkuCodeIn(skuCode);
				//.stream().map(Inventory::getSkuCode)
				//.allMatch(this::isAvailable);

		return null;
	}

	public boolean isAvailable(String skuCode) {
		boolean existsInInventory = inventoryRepo.existsBySkuCode(skuCode);

		return existsInInventory;
	}

}
