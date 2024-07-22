package org.blackstone.retail.domain.handler;

import java.math.BigDecimal;

public class CustomerDiscountHandler extends DiscountHandler {

    @Override
    public BigDecimal applyDiscount(BigDecimal totalAmount) {

        BigDecimal discount = totalAmount.multiply(BigDecimal.valueOf(0.05));

        if (nextHandler != null) {
            return nextHandler.applyDiscount(totalAmount.subtract(discount));
        }

        return totalAmount.subtract(discount);
    }
}
