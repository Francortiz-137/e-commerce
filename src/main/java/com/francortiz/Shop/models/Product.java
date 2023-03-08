package com.francortiz.Shop.models;

import com.francortiz.Shop.enums.Type;
import com.francortiz.Shop.exceptions.InvalidPriceException;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String name;
    @Nonnull
    private Type type;
    private String description;
    @Nonnull
    private Double price;
    private String photo;

    public Product(String name, Type type, String description, Double price, String photo) {
        this.name = name;
        this.type =type;
        this.description = description;
        this.price = price;
        this.photo = photo;
    }

    public void setPrice(Double price) {
        if(price > 0)
            this.price = price;
        else
            throw new InvalidPriceException("Ingrese un precio valido");
    }
}
