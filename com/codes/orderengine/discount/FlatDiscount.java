package com.codes.orderengine.discount;

import java.math.BigDecimal;

import com.codes.orderengine.exception.InvalidAmountException;

public class FlatDiscount implements Discount {
    
    private final BigDecimal amount;

    public FlatDiscount(BigDecimal amount) throws InvalidAmountException {
        if(amount.compareTo(BigDecimal.ZERO) == -1) {
            throw new InvalidAmountException("Amount should greater than or equal to zero");
        }

        this.amount = amount;
    }

    public BigDecimal discountAmount(BigDecimal subTotal) {
        return subTotal.min(amount);
    }
}
