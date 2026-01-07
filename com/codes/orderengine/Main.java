package com.codes.orderengine;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.codes.orderengine.discount.Discount;
import com.codes.orderengine.discount.NoDiscount;
// import com.codes.orderengine.discount.PercentageDiscount;
import com.codes.orderengine.exception.InvalidDateException;
import com.codes.orderengine.exception.InvalidDiscountException;
import com.codes.orderengine.exception.InvalidItemException;
import com.codes.orderengine.exception.InvalidOrderNumberException;
import com.codes.orderengine.exception.InvalidPercentageException;
import com.codes.orderengine.exception.InvalidPriceException;
import com.codes.orderengine.exception.InvalidQuantityException;
import com.codes.orderengine.order.Order;
import com.codes.orderengine.order.OrderItem;

public class Main {
    public static void main(String args[]) throws InvalidPriceException, InvalidQuantityException, InvalidPercentageException, InvalidOrderNumberException, InvalidDateException, InvalidItemException, InvalidDiscountException {
        OrderItem item1 = new OrderItem(
                "PRODUCT-001",
                new BigDecimal("500"),
                2,
                new String[] { "Color: Black" }
        );

        OrderItem item2 = new OrderItem(
                "PRODUCT-002",
                new BigDecimal("300"),
                1,
                null
        );

        // 2. Choose discount strategy
        // Discount discount = new PercentageDiscount(new BigDecimal("10"));
        Discount discount = new NoDiscount();

        // 3. Create order
        Order order = new Order(
                "ORDER-1001",
                LocalDate.now(),
                Set.of(item1, item2),
                discount
        );

        // 4. Calculate payable amount
        BigDecimal payableAmount = order.payableAmount();

        // 5. Print result
        System.out.println("Order Number   : " + "ORDER-1001");
        System.out.println("Order Date     : " + LocalDate.now());
        System.out.println("Payable Amount : " + payableAmount);
    }
}
