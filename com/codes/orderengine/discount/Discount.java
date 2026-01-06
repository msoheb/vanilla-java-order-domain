package com.codes.orderengine.discount;

import java.math.BigDecimal;

public interface Discount {

    BigDecimal discountAmount(BigDecimal subTotal);
    
}
