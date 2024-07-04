package dev.be.onlinecoffeeorder.domain;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "orders")
public class Order {

    @Id
    private int orderId;

    @Column
    private int customerId;

    @Column
    private Timestamp orderAt;


    @MappedCollection(idColumn = "order_item_id", keyColumn = "order_id") // MappedCollection은 1:N 관계를 표현할 때 사용
    private List<OrderItem> orderItems = new ArrayList<>(); //설명: 주문에 대한 상품 목록

    public Order(int customerId, List<OrderItem> orderItems) {
        this.customerId = customerId;
        this.orderAt = Timestamp.valueOf(LocalDateTime.now());
        this.orderItems = orderItems;
    }


    public static Order newOrder(CreateOrder createOrder) {
        return new Order(createOrder.getCustomerId(), createOrder.getOrderItems());
    }
}
