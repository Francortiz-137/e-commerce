package com.francortiz.Shop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    @Column(length = 20)
    private String firstName;
    @Nonnull
    @Column(length = 20)
    private String lastName;
    @Nonnull
    @Column(unique = true, length = 20)
    @Email(message = "no es una direccion de correo bien formada")
    private String email;
    @Nonnull
    @Column(length = 20)
    private String password;
    @Nonnull
    @Column(length = 100)
    private String address;
    @Nonnull
    @Column(unique = true, length = 15)
    private String phone;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime CreatedAt;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime UpdatedAt;

    private Boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","role_id"})})
    private List<Role> roles;

    @JsonIgnoreProperties(value={"user","hibernateLazyInitializer", "handler"},allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart = new Cart();

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
