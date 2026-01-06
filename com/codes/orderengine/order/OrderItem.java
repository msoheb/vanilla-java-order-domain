package com.codes.orderengine.order;

import java.math.BigDecimal;

import com.codes.orderengine.exception.InvalidPriceException;
import com.codes.orderengine.exception.InvalidQuantityException;

public class OrderItem {
    private final String productId;
    private final BigDecimal price;
    private final int quantity;
    private final String[] variants;

    public OrderItem(String productId, BigDecimal price, int quantity, String[] variants) throws InvalidPriceException, InvalidQuantityException {
        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("productId must not be null or blank");
        }
        this.productId = productId;

        if(price.compareTo(BigDecimal.ZERO) < 0) {
            throw new  InvalidPriceException("Price must be greater than zero");
        } else {
            this.price = price;
        }

        if(quantity <= 0) {
            throw new  InvalidQuantityException("Quantity must be greater than zero");
        } else {
            this.quantity = quantity;
        }

        this.variants = variants != null ? variants.clone() : null;

    }

    private BigDecimal orderItemTotal(BigDecimal price, int quantity) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }



}
