package org.blackstone.retail.util;

import java.math.BigDecimal;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.blackstone.retail.domain.dto.ProductDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BillUtil {

    public static BigDecimal calculateTotalAmount(List<ProductDto> products) {
        return products.stream()
                .map(ProductDto::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
