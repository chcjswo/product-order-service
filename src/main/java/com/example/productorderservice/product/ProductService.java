package com.example.productorderservice.product;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2023-02-15
 **/
public class ProductService {
	protected final ProductPort productPort;

	public ProductService(ProductPort productPort) {
		this.productPort = productPort;
	}

	public void addProduct(AddProductRequest request) {
		final Product product = new Product(request.name(), request.price(), request.discountPolicy());
		productPort.save(product);
	}
}
