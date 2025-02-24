package com.vikas.telecomDiscounts.service;


import com.vikas.telecomDiscounts.model.Bill;
import com.vikas.telecomDiscounts.model.CustomerType;
import com.vikas.telecomDiscounts.model.Discount;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class TelecomDiscountService {
    private Map<String,Set<Discount>> discountMap=new HashMap<>();

    @PostConstruct
    public void init() {
        Set<Discount> regularSet = new TreeSet<>();
        regularSet.add(new Discount(0,0,CustomerType.REGULAR));
        regularSet.add(new Discount(5000,10,CustomerType.REGULAR));
        regularSet.add(new Discount(10000,20,CustomerType.REGULAR));
        discountMap.put(CustomerType.REGULAR.getDisplayValue(),regularSet);
        Set<Discount> premiumSet = new TreeSet<>();
        premiumSet.add(new Discount(0,10,CustomerType.PREMIUM));
        premiumSet.add(new Discount(4000,15,CustomerType.PREMIUM));
        premiumSet.add(new Discount(8000,20,CustomerType.PREMIUM));
        premiumSet.add(new Discount(12000,30,CustomerType.PREMIUM));
        discountMap.put(CustomerType.PREMIUM.getDisplayValue(),premiumSet);

    }

       public Set<Discount> getDiscounts(CustomerType customerType) {
        if(discountMap.containsKey(customerType.getDisplayValue())) {
            return discountMap.get(customerType.getDisplayValue());
        }
        return null;
    }

     public void addDiscount(Discount discount) {
        if(discountMap.containsKey(discount.getCustomerType().getDisplayValue())){
           Set<Discount> discountSet=discountMap.get(discount.getCustomerType().getDisplayValue());
           discountSet.add(discount);
        }else{
            Set<Discount> discountSet=new TreeSet<>();
            discountSet.add(discount);
            discountMap.put(discount.getCustomerType().getDisplayValue(),discountSet);
        }
    }


    private Set<Discount> findByCustomerType(CustomerType customerType) {
        Set<Discount> discSet=discountMap.get(customerType.getDisplayValue());
        return discSet;
    }

    public double getDiscountedBillAmount(Bill bill) {
        Set<Discount> discounts=findByCustomerType(bill.getCustomerType());
       if(discounts.isEmpty()){
          return bill.getPurchaseAmount();
       }
       double amount=bill.getPurchaseAmount();
        double discountAmount=0.0;
       for(Discount discount:discounts) {
           if(amount>discount.getMinAmt()){
               double discountFor=amount-discount.getMinAmt();
               discountAmount += (discountFor * discount.getDiscountPerc()) / 100;
               amount=discount.getMinAmt();
           }
       }
       return bill.getPurchaseAmount()-discountAmount;
    }
}
