package org.global.repository;

import org.global.model.Product;

import java.util.Optional;

public interface ProductRepository {
    Optional findById(Long id);
    Product save(Product product);

}
