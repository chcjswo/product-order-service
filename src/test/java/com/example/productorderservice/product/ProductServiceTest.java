package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2023-02-15
 **/
@SpringBootTest
class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	void addProduct() {
		final AddProductRequest request = getAddProductRequest();
		productService.addProduct(request);
	}

	private static AddProductRequest getAddProductRequest() {
		final String name = "상품명";
		final int price = 1000;
		final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
		return new AddProductRequest(name, price, discountPolicy);
	}
}
