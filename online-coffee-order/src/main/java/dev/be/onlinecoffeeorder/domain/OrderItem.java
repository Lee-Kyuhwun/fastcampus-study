package dev.be.onlinecoffeeorder.domain;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "order_items")
public class OrderItem {


    @Id
    private int orderItemId;

    private int productId;

    private int quantity;


}
