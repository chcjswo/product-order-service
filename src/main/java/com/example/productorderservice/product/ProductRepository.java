package com.example.productorderservice.product;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2023-02-15
 **/
@Repository
public class ProductRepository {
	private Long sequence = 0L;
	private Map<Long, Product> persistence = new HashMap<>();

	public void save(final Product product) {
		product.assignId(++sequence);
		persistence.put(product.getId(), product);
	}
}
