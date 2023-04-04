package com.francortiz.Shop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Double total = 0.0;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id")
    private List<CartItem> items = new ArrayList<CartItem>();

    @JsonIgnoreProperties(value={"user","hibernateLazyInitializer", "handler"},allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id")
    private User user;

    public Double getTotal(){
        Double total = 0.0;
        for (CartItem item: items){
            total += item.getSubTotal();
        }
        return total;
    }

    public void addCartItems(CartItem cartItem){
        items.add(cartItem);
    }

}
