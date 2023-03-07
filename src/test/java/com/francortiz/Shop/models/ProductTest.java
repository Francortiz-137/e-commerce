package com.francortiz.Shop.models;

import com.francortiz.Shop.exceptions.InvalidPriceException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;
    @BeforeAll
    static void beforeAll() {
    }

    @BeforeEach
    void setUp() {
        this.product = new Product();
    }

    @Test
    void test_name_product() {

        this.product.setName("Producto");
        String expected = "Producto";

        assertEquals( expected, this.product.getName());
    }

    @Test
    void test_description_product() {

        this.product.setDescription("Producto");
        String expected = "Producto";

        assertEquals( expected, this.product.getDescription());
    }

    @Test
    void test_type_product() {

        this.product.setType("Producto");
        String expected = "Producto";

        assertEquals( expected, this.product.getType());
        //TODO assert typo corresponda enum types
    }

    @Test
    void test_photo_product() {

        this.product.setPhoto("Producto");
        String expected = "Producto";

        assertEquals( expected, this.product.getPhoto());

        //TODO assert path points to an actual img if not throws an exception
    }

    @Test
    void test_price_not_zero_or_less() {
        Product product = new Product();

        Exception exception = assertThrows(InvalidPriceException.class,() ->{
            product.setPrice( -100.0);
        }, "Ingrese un precio valido");

        assertEquals("Ingrese un precio valido", exception.getMessage());
    }
}