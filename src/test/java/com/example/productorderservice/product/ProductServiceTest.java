package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2023-02-15
 **/
class ProductServiceTest {

	private ProductService productService;
	private ProductPort productPort;
	private ProductRepository productRepository;

	@BeforeEach
	void setUp() {
		productRepository = new ProductRepository();
		productPort = new ProductAdapter(productRepository);
		productService = new ProductService(productPort);
	}

	@Test
	void addProduct() {
		final String name = "상품명";
		final int price = 1000;
		final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
		final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
		productService.addProduct(request);
	}

	private record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {
		private AddProductRequest {
			Assert.hasText(name, "상품명은 필수입니다.");
			Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
			Assert.notNull(discountPolicy, "할인 정책은 필수 입니다.");
		}
	}

	private enum DiscountPolicy {
		NONE
	}

	private class ProductService {
		private final ProductPort productPort;

		private ProductService(ProductPort productPort) {
			this.productPort = productPort;
		}

		public void addProduct(AddProductRequest request) {
			final Product product = new Product(request.name(), request.price(), request.discountPolicy());
			productPort.save(product);
		}
	}

	private class Product {
		private final String name;
		private final int price;
		private final DiscountPolicy discountPolicy;
		private Long id;

		public Product(String name, int price, DiscountPolicy discountPolicy) {
			this.name = name;
			this.price = price;
			this.discountPolicy = discountPolicy;
		}

		public void assignId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return id;
		}
	}

	private interface ProductPort {

		void save(Product product);
	}

	private class ProductAdapter implements ProductPort {

		private final ProductRepository productRepository;

		private ProductAdapter(ProductRepository productRepository) {
			this.productRepository = productRepository;
		}

		@Override
		public void save(Product product) {

		}
	}

	private class ProductRepository {
		private Long sequence = 0L;
		private Map<Long, Product> persistence = new HashMap<>();

		public void save(final Product product) {
			product.assignId(++sequence);
			persistence.put(product.getId(), product);
		}
	}
}