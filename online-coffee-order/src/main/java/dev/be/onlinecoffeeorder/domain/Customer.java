package dev.be.onlinecoffeeorder.domain;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "customers")
public class Customer {

    @Id
    private int customerId;

    @Column
    private String address;

    @Column
    private String name;

    @Column
    private String phoneNumber;


    public Customer(String address, String name, String phoneNumber) {
        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public static Customer newCustomer(CreateCustomer createCustomer) {
        return new Customer(createCustomer.getAddress(), createCustomer.getName(), createCustomer.getPhoneNumber());
    }
}
