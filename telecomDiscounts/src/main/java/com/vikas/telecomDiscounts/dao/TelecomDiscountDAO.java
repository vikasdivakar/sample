package com.vikas.telecomDiscounts.dao;

import com.vikas.telecomDiscounts.model.CustomerType;
import com.vikas.telecomDiscounts.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelecomDiscountDAO extends JpaRepository<Discount,Long> {
    List<Discount> findByCustomerType(CustomerType customerType);
}
