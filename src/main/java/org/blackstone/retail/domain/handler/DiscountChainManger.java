package org.blackstone.retail.domain.handler;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import org.blackstone.retail.domain.dto.CartDto;
import org.blackstone.retail.domain.entity.User;
import org.blackstone.retail.domain.enums.UserType;
import org.blackstone.retail.util.BillUtil;
import org.blackstone.retail.util.DateUtil;
import org.springframework.stereotype.Service;

@Service
public class DiscountChainManger {

    public BigDecimal calculateNetPayableAmount(User user, CartDto cartDto) {
        BigDecimal totalAmount = BillUtil.calculateTotalAmount(cartDto.getProducts());
        DiscountHandler discountHandler = handler(user);
        return discountHandler.applyDiscount(totalAmount);
    }

    private DiscountHandler handler(User user) {

        UserType userType = user.getUserType();
        Instant createDate = user.getCreatedAt();
        Instant date2YearFromNow = DateUtil.get_2_years_old_instant();

        DiscountHandler discountHandler = null;

        if (user.getUserType() == UserType.EMPLOYEE) {

            discountHandler = new EmployeeDiscountHandler();
        } else if (user.getUserType() == UserType.AFFILIATE) {

            discountHandler = new AffiliateDiscountHandler();
        } else if (userType.equals(UserType.CUSTOMER) && createDate.isBefore(date2YearFromNow)) {

            discountHandler = new CustomerDiscountHandler();
        }

        if (Objects.isNull(discountHandler)) {
            return new FlatDiscountHandler();
        }

        discountHandler.setNextHandler(new FlatDiscountHandler());

        return discountHandler;
    }
}
