package com.vikas.telecomDiscounts.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Bill {
    @NotNull(message = "Amount Required")
    @Min(value = 0,message = "Amount should be more than zero")
    private double purchaseAmount;
    private CustomerType customerType=CustomerType.REGULAR;

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
