package org.blackstone.retail.object_mother;

import org.blackstone.retail.domain.dto.CartDto;

public class CartObjectMother {

    public static CartDto getCartDto() {

        CartDto cartDto = new CartDto();
        cartDto.setUserId(1L);
        cartDto.setProducts(ProductObjectMother.getProductList());
        return cartDto;
    }
}
