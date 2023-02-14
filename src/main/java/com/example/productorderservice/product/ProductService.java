package com.example.productorderservice.product;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2023-02-15
 **/
@Service
public class ProductService {
	protected final ProductPort productPort;

	public ProductService(ProductPort productPort) {
		this.productPort = productPort;
	}

	@Transactional
	public void addProduct(AddProductRequest request) {
		final Product product = new Product(request.name(), request.price(), request.discountPolicy());
		productPort.save(product);
	}
}
