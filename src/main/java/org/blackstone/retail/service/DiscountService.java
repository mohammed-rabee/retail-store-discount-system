package org.blackstone.retail.service;

import java.math.BigDecimal;
import org.blackstone.retail.domain.dto.CartDto;

public interface DiscountService {

    BigDecimal applyDiscount(CartDto cartDto);
}
