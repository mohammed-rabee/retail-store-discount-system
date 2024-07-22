package org.blackstone.retail.domain.handler;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.blackstone.retail.domain.dto.CartDto;
import org.blackstone.retail.domain.entity.User;
import org.blackstone.retail.object_mother.CartObjectMother;
import org.blackstone.retail.object_mother.UserObjectMother;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountChainMangerTest {

    private DiscountChainManger discountChainManger;

    @BeforeEach
    void setUp() {
        discountChainManger = new DiscountChainManger();
    }

    @AfterEach
    void tearDown() {
        discountChainManger = null;
    }

    @Test
    @DisplayName("Test Calculate Flat Discount Only")
    void calculateNetPayableAmountWithFlatDiscountOnly() {

        User user = UserObjectMother.get_1_years_customer_user();
        CartDto cartDto = CartObjectMother.getCartDto();

        BigDecimal result = discountChainManger.calculateNetPayableAmount(user, cartDto);

        assertEquals(BigDecimal.valueOf(945), result);
    }

    @Test
    @DisplayName("Test Calculate Employee And Flat Discounts")
    void calculateNetPayableAmountWithEmployeeAndFlatDiscount() {

        User user = UserObjectMother.getEmployeeUser();
        CartDto cartDto = CartObjectMother.getCartDto();

        BigDecimal result = discountChainManger.calculateNetPayableAmount(user, cartDto);

        assertEquals(BigDecimal.valueOf(663.0), result);
    }

    @Test
    @DisplayName("Test Calculate Affiliate And Flat Discounts")
    void calculateNetPayableAmountWithAffiliateAndFlatDiscount() {

        User user = UserObjectMother.getAffiliateUser();
        CartDto cartDto = CartObjectMother.getCartDto();

        BigDecimal result = discountChainManger.calculateNetPayableAmount(user, cartDto);

        assertEquals(BigDecimal.valueOf(851.0), result);
    }
}