package com.codes.orderengine.order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.codes.orderengine.discount.Discount;
import com.codes.orderengine.exception.InvalidDateException;
import com.codes.orderengine.exception.InvalidDiscountException;
import com.codes.orderengine.exception.InvalidItemException;
import com.codes.orderengine.exception.InvalidOrderNumberException;

public class Order {
    private final String orderNumber;
    private final LocalDate orderDate;
    private final Set<OrderItem> items;
    private final Discount discount;

    public Order(String orderNumber, LocalDate orderDate, Set<OrderItem> items, Discount discount) throws InvalidOrderNumberException, InvalidDateException, InvalidItemException, InvalidDiscountException {
        if(orderNumber == null || orderNumber.isBlank()) {
            throw new InvalidOrderNumberException("Enter valid order number");
        }

        this.orderNumber = orderNumber;

        if(orderDate == null) {
            throw new InvalidDateException("Date must valid ");
        }

        this.orderDate = orderDate;

        if(items == null || items.isEmpty()) {
            throw new InvalidItemException("Item cannot be empty");
        }

        this.items = new HashSet<>(items);

        if(discount == null) {
            throw new InvalidDiscountException("Discount amount should not be null");
        }

        this.discount = discount;


    }

    public BigDecimal payableAmount() {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for(OrderItem item : items) {
            BigDecimal lineTotal = item.orderItemTotal();
            totalAmount = totalAmount.add(lineTotal);
        }

        return totalAmount.subtract(discount.discountAmount(totalAmount));       
    }
}