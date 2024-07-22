package org.blackstone.retail.domain.handler;

import java.math.BigDecimal;

public class EmployeeDiscountHandler extends DiscountHandler {

    @Override
    public BigDecimal applyDiscount(BigDecimal totalAmount) {

        BigDecimal discount = totalAmount.multiply(BigDecimal.valueOf(0.3));

        if (nextHandler != null) {
            return nextHandler.applyDiscount(totalAmount.subtract(discount));
        }

        return totalAmount.subtract(discount);
    }
}
