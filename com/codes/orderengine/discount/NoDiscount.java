package com.codes.orderengine.discount;

import java.math.BigDecimal;

public class NoDiscount implements Discount {

    public BigDecimal discountAmount(BigDecimal subTotal) {
        return BigDecimal.ZERO;
    }
    
}
