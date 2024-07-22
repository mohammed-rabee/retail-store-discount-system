package org.blackstone.retail.domain.handler;

import java.math.BigDecimal;

public abstract class DiscountHandler {

    protected DiscountHandler nextHandler;

    public void setNextHandler(DiscountHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract BigDecimal applyDiscount(BigDecimal totalAmount);
}
