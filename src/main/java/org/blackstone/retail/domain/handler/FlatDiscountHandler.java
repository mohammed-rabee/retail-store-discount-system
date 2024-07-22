package org.blackstone.retail.domain.handler;

import java.math.BigDecimal;

public class FlatDiscountHandler extends DiscountHandler {

    @Override
    public BigDecimal applyDiscount(BigDecimal totalAmount) {

        BigDecimal[] bigDecimals = totalAmount.divideAndRemainder(new BigDecimal("100"));
        BigDecimal discount = bigDecimals[0].multiply(new BigDecimal("5"));

        if (nextHandler != null) {
            return nextHandler.applyDiscount(totalAmount.subtract(discount));
        }

        return totalAmount.subtract(discount);
    }
}
