package com.product.controller;

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

import com.product.dto.AllProductsResponseDto;
import com.product.dto.CreateproductDto;
import com.product.entity.Product;
import com.product.services.ProductServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

	private final ProductServices productServices;

	@PostMapping("/create")
	private final ResponseEntity<?> createProduct(@RequestBody CreateproductDto createProduct) {
		Product isProductSave = this.productServices.creteProduct(createProduct);
		Map<String, Object> messsage = new HashMap<String, Object>();
		messsage.put("product", isProductSave);
		messsage.put("success", "Successfully Created");
		return (isProductSave != null) ? new ResponseEntity<Map<String, Object>>(messsage, HttpStatus.CREATED)
				: new ResponseEntity<Integer>(HttpStatus.CREATED);
	}

	@GetMapping("/over-all")
	public List<AllProductsResponseDto> allProduct() {
		return productServices.getAllProduct();
	}

}
