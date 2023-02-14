package com.example.productorderservice.product;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2023-02-15
 **/
public class ProductAdapter implements ProductPort {
	protected final ProductRepository productRepository;

	public ProductAdapter(ProductRepository productRepository) {this.productRepository = productRepository;}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}
}
