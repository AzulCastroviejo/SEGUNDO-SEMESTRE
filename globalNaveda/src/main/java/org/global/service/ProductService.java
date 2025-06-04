package org.global.service;

import org.global.model.Product;
import org.global.repository.ProductRepository;

import java.util.Optional;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product buscarProducto(String nombre){return productRepository.obtenerProducto(nombre);}

}
