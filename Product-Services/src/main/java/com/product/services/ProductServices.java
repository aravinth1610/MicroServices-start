package com.product.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.product.dto.AllProductsResponseDto;
import com.product.dto.CreateproductDto;
import com.product.entity.Product;
import com.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServices {

	private final ProductRepository productRepo;

	public Product creteProduct(CreateproductDto createProduct) {
		Product product = new Product();
		BeanUtils.copyProperties(createProduct, product);
		return this.productRepo.save(product);

	}

	public List<AllProductsResponseDto> getAllProduct() {

		return productRepo.findAll().stream().map(product -> {
			AllProductsResponseDto productResponse = new AllProductsResponseDto();
			BeanUtils.copyProperties(product, productResponse);
			return productResponse;
		}).collect(Collectors.toList());

	}

}
