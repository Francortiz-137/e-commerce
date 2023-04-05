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
@Table(name = "orden")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double total;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private List<OrderItem> items = new ArrayList<OrderItem>();
    @JsonIgnoreProperties(value={"user","hibernateLazyInitializer", "handler"},allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private User user;

    public Double getTotal(){
        Double total = 0.0;
        for (OrderItem item: items){
            total += item.getSubTotal();
        }
        return total;
    }

    public void addOrderItems(OrderItem orderItem) {
        items.add(orderItem);
    }
    //private List<OrderStatus> status; TODO
}
