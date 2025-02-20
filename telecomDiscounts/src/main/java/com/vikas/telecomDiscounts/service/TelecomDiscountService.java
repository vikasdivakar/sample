package com.vikas.telecomDiscounts.service;

import com.vikas.telecomDiscounts.dao.TelecomDiscountDAO;
import com.vikas.telecomDiscounts.model.Bill;
import com.vikas.telecomDiscounts.model.CustomerType;
import com.vikas.telecomDiscounts.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class TelecomDiscountService {
    @Autowired
    private TelecomDiscountDAO telecomDiscountDAO;

    public Discount addDiscount(Discount discount) {
        return telecomDiscountDAO.save(discount);
    }

    private Discount fetchDiscount(CustomerType customerType,double billAmount){
     List<Discount> discounts=telecomDiscountDAO.findByCustomerType(customerType);
       if(!discounts.isEmpty()) {
           for (Discount discount : discounts) {
               if (billAmount >= discount.getMinAmt() && billAmount <= discount.getMaxAmt()) {
                   return discount;
               }
           }
       }
        return null;
    }

    public double getDiscountedBillAmount(Bill bill) {
       Discount discount=fetchDiscount(bill.getCustomerType(),bill.getAmount());
       if(discount==null){
          return bill.getAmount();
       }
       double discountAmount=(bill.getAmount()*discount.getDiscountPerc())/100;
       return bill.getAmount()-discountAmount;
    }

    public List<Discount> getAllDiscounts(){
       return telecomDiscountDAO.findAll();
    }
}
