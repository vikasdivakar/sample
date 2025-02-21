package com.vikas.telecomDiscounts.controller;

import com.vikas.telecomDiscounts.model.Bill;
import com.vikas.telecomDiscounts.model.Discount;
import com.vikas.telecomDiscounts.service.TelecomDiscountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telecom/discounts")
@Validated
public class TelecomDiscountController {
    @Autowired
    TelecomDiscountService telecomDiscountService;
    @PostMapping("/applyDiscount")
    public double getDiscountedBill(@Valid @RequestBody Bill bill) {
        return telecomDiscountService.getDiscountedBillAmount(bill);
    }

    @PostMapping
    public ResponseEntity<Discount> createDiscount(@Valid @RequestBody Discount discount) {
        Discount savedDiscount = telecomDiscountService.addDiscount(discount);
        return new ResponseEntity<>(savedDiscount, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Discount>> getAllDiscounts() {
        List<Discount> discounts=telecomDiscountService.getAllDiscounts();
        if (!discounts.isEmpty()) {
            return new ResponseEntity<>(discounts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
