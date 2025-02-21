package com.vikas.telecomDiscounts.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;
    @NotNull(message = "minAmt Required")
    @Min(value = 0,message = "minimum amount should be positive")
    private double minAmt;
    @NotNull(message = "maxAmt Required")
    @Min(value = 0,message = "maximum amount should be positive")
    private double maxAmt;
    @NotNull(message = "discountPerc Required")
    @Min(value = 0,message = "discountPerc should be positive")
    private double discountPerc;
    @Enumerated(EnumType.STRING)
    private CustomerType customerType=CustomerType.REGULAR;

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public double getMinAmt() {
        return minAmt;
    }

    public void setMinAmt(double minAmt) {
        this.minAmt = minAmt;
    }

    public double getMaxAmt() {
        return maxAmt;
    }

    public void setMaxAmt(double maxAmt) {
        this.maxAmt = maxAmt;
    }

    public double getDiscountPerc() {
        return discountPerc;
    }

    public void setDiscountPerc(double discountPerc) {
        this.discountPerc = discountPerc;
    }
    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
