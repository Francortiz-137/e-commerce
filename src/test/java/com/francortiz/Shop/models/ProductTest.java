package com.francortiz.Shop.models;

import com.francortiz.Shop.enums.Type;
import com.francortiz.Shop.exceptions.InvalidPriceException;
import jakarta.activation.MimetypesFileTypeMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

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

        this.product.setType(Type.ELECTRONICOS);
        Type expected = Type.valueOf("ELECTRONICOS");

        assertEquals( expected, this.product.getType());

    }

    @Test
    void test_not_unknown_type_product() {

        assertThrows( RuntimeException.class,() -> this.product.setType(Type.valueOf("NEW_TYPE")));

    }

    @Test
    void test_photo_product() {

        this.product.setPhoto("img1.jpg");
        String expected = "img1.jpg";

        File f = new File("img1.jpg");
        String mimetype= new MimetypesFileTypeMap().getContentType(f);
        String type = mimetype.split("/")[0];

        assertEquals( expected, this.product.getPhoto());
        assertNotNull(f);
        //assertTrue(f.exists());
        assertEquals("image", type);
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