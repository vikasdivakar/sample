package com.vikas.telecomDiscounts.model;

import jakarta.persistence.*;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;
    private double minAmt;
    private double maxAmt;
    private double discountPerc;
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

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
