package com.vikas.telecomDiscounts.controller;

import com.vikas.telecomDiscounts.model.Bill;
import com.vikas.telecomDiscounts.model.CustomerType;
import com.vikas.telecomDiscounts.model.Discount;
import com.vikas.telecomDiscounts.model.Response;
import com.vikas.telecomDiscounts.service.TelecomDiscountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/telecom/discounts")
@Validated
public class TelecomDiscountController {
    @Autowired
    TelecomDiscountService telecomDiscountService;
    @PostMapping("/applyDiscount")
    public ResponseEntity<Response> getDiscountedBill(@Valid @RequestBody Bill bill) {
        double amount= telecomDiscountService.getDiscountedBillAmount(bill);
        Response response=new Response();
        response.setBillAmount(amount);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createDiscount(@Valid @RequestBody Discount discount) {
      telecomDiscountService.addDiscount(discount);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Set<Discount>> getAllDiscountsByCustomerType(@RequestParam("customerType") CustomerType customerType) {
        Set<Discount> discounts=telecomDiscountService.getDiscounts(customerType);
        if (!discounts.isEmpty()) {
            return new ResponseEntity<>(discounts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
