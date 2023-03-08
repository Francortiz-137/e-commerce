package com.francortiz.Shop.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private String firstName;
    @Nonnull
    private String lastName;
    @Nonnull
    private String email;
    @Nonnull
    private String password;
    @Nonnull
    private String address;
    @Nonnull
    private String phone;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;

    public User(String firstName, String lastName, String email, String password, String address, String phone, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.CreatedAt = createdAt;
        this.UpdatedAt = updatedAt;
    }
}
