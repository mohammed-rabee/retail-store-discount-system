package org.blackstone.retail;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import org.blackstone.retail.domain.dto.CartDto;
import org.blackstone.retail.domain.entity.User;
import org.blackstone.retail.domain.handler.DiscountChainManger;
import org.blackstone.retail.object_mother.CartObjectMother;
import org.blackstone.retail.object_mother.UserObjectMother;
import org.blackstone.retail.service.UserService;
import org.blackstone.retail.service.impl.DiscountServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiscountServiceImplTest {

    @InjectMocks
    private DiscountServiceImpl discountService;

    @Mock
    private UserService userService;

    @Mock
    private DiscountChainManger discountChainManger;

    public DiscountServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Mock Test Applying Flat Discount Only")
    public void test_apply_flat_discount_only() {

        User user = UserObjectMother.get_1_years_customer_user();
        CartDto cartDto = CartObjectMother.getCartDto();

        when(userService.getUserById(1L)).thenReturn(user);
        when(discountChainManger.calculateNetPayableAmount(user, cartDto))
                .thenReturn(BigDecimal.valueOf(945));

        BigDecimal result = discountService.applyDiscount(cartDto);

        assertEquals(BigDecimal.valueOf(945), result);
    }

    @Test
    @DisplayName("Mock Test Applying Employee And Flat Discounts")
    public void test_apply_employee_and_flat_discount() {

        User user = UserObjectMother.getEmployeeUser();
        CartDto cartDto = CartObjectMother.getCartDto();

        when(userService.getUserById(1L)).thenReturn(user);
        when(discountChainManger.calculateNetPayableAmount(user, cartDto))
                .thenReturn(BigDecimal.valueOf(663));

        BigDecimal result = discountService.applyDiscount(cartDto);

        assertEquals(BigDecimal.valueOf(663), result);
    }

    @Test
    @DisplayName("Mock Test Applying Affiliate And Flat Discounts")
    public void test_apply_affiliate_and_flat_discount() {

        User user = UserObjectMother.getAffiliateUser();
        CartDto cartDto = CartObjectMother.getCartDto();

        when(userService.getUserById(1L)).thenReturn(user);
        when(discountChainManger.calculateNetPayableAmount(user, cartDto))
                .thenReturn(BigDecimal.valueOf(851));

        BigDecimal result = discountService.applyDiscount(cartDto);

        assertEquals(BigDecimal.valueOf(851), result);
    }
}
