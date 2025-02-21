package com.vikas.telecomDiscounts.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Bill {
    @NotNull(message = "Amount Required")
    @Min(value = 0,message = "Amount should be more than zero")
    private double amount;
    private CustomerType customerType=CustomerType.REGULAR;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
