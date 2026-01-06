package com.codes.orderengine.discount;

import java.math.BigDecimal;

import com.codes.orderengine.exception.InvalidPercentageException;

public class PercentageDiscount implements Discount {
    private final BigDecimal percentage;

    public PercentageDiscount(BigDecimal percentage) throws InvalidPercentageException {
        if(percentage.compareTo(BigDecimal.ZERO) == -1 || percentage.compareTo(new BigDecimal("100")) == 1) {
            throw new InvalidPercentageException("Percentage should be between Zero and Hundred");
        }

        this.percentage = percentage;
    }
    
    public BigDecimal discountAmount(BigDecimal subTotal) {
        return subTotal.multiply(percentage).divide(new BigDecimal("100"));
        
    }
}
