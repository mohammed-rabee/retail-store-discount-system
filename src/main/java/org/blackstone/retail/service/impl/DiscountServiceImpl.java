package org.blackstone.retail.service.impl;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.blackstone.retail.domain.dto.CartDto;
import org.blackstone.retail.domain.entity.User;
import org.blackstone.retail.domain.handler.DiscountChainManger;
import org.blackstone.retail.service.DiscountService;
import org.blackstone.retail.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final UserService userService;
    private final DiscountChainManger discountChainManger;

    @Override
    public BigDecimal applyDiscount(CartDto cartDto) {

        User user = userService.getUserById(cartDto.getUserId());
        return discountChainManger.calculateNetPayableAmount(user, cartDto);
    }
}
