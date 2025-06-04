package org.global.service;

import org.global.model.Product;
import org.global.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceTest   {
    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(productRepository);
    }

    @Test
    public void testCreateProduct() {
       Product product = new Product(1L, "PAPAS FRITAS", 5862.36);

        when(productRepository.save(product)).thenReturn(product);

        Product resultado = productService.createProduct(product);

        assertEquals(product , resultado);
    }
    @Test
    public void testBuscar(){
        Product product = new Product();
        when(productRepository.obtenerProducto("PAPAS FRITAS")).thenReturn(product);
        Product resultado = productService.buscarProducto("PAPAS FRITAS");
        assertEquals( product,resultado ) ;
    }


}
