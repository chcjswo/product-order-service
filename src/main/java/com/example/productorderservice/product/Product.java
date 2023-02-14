package com.example.productorderservice.product;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2023-02-15
 **/
public class Product {
	protected final String name;
	protected final int price;
	protected final DiscountPolicy discountPolicy;
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
