package com.vikas.telecomDiscounts.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;


public class Discount implements Comparable<Discount>{


    @NotNull(message = "minAmt Required")
    @Min(value = 0,message = "minimum amount should be positive")
    private double minAmt;
    @NotNull(message = "discountPerc Required")
    @Min(value = 0,message = "discountPerc should be positive")
    private double discountPerc;
    @Enumerated(EnumType.STRING)
    private CustomerType customerType=CustomerType.REGULAR;

    public double getMinAmt() {
        return minAmt;
    }

    public void setMinAmt(double minAmt) {
        this.minAmt = minAmt;
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

    public Discount(double minAmt, double discountPerc, CustomerType customerType) {
        this.minAmt = minAmt;
        this.discountPerc = discountPerc;
        this.customerType = customerType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return Double.compare(discount.minAmt, minAmt) == 0 && Double.compare(discount.discountPerc, discountPerc) == 0 && customerType == discount.customerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minAmt, discountPerc, customerType);
    }

    @Override
    public int compareTo(Discount o) {
        return Double.compare(o.minAmt,this.minAmt);
    }
}
