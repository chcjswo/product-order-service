package com.example.productorderservice.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2023-02-15
 **/
@RestController
@RequestMapping("/products")
public class ProductService {
	private final ProductPort productPort;

	public ProductService(ProductPort productPort) {
		this.productPort = productPort;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Void> addProduct(@RequestBody AddProductRequest request) {
		final Product product = new Product(request.name(), request.price(), request.discountPolicy());
		productPort.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
