package com.francortiz.Shop.models;

import com.francortiz.Shop.enums.Type;
import com.francortiz.Shop.exceptions.InvalidPriceException;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "products")
@SQLDelete(sql = "UPDATE products SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    @Column(unique = true, length = 20)
    private String name;
    @Nonnull
    private Type type;
    @Column(length = 100)
    private String description;
    @Nonnull
    private Double price;
    private String photo;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    private boolean isDeleted = false;


    public Product(String name, Type type, String description, Double price, String photo, LocalDateTime createdAt) {
        this.name = name;
        this.type =type;
        this.description = description;
        this.price = price;
        this.photo = photo;
        this.createdAt = createdAt;
    }

    public void setPrice(Double price) {
        if(price > 0)
            this.price = price;
        else
            throw new InvalidPriceException("Ingrese un precio valido");
    }
}
