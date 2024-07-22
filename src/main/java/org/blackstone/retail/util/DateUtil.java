package org.blackstone.retail.util;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.blackstone.retail.domain.dto.ProductDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

    public static Instant get_1_years_old_instant() {

        ZonedDateTime now = ZonedDateTime.now();

        ZonedDateTime twoYearsAgo = now.minusYears(1);

        return twoYearsAgo.toInstant();
    }

    public static Instant get_2_years_old_instant() {

        ZonedDateTime now = ZonedDateTime.now();

        ZonedDateTime twoYearsAgo = now.minusYears(2);

        return twoYearsAgo.toInstant();
    }

    public static BigDecimal calculateTotalAmount(List<ProductDto> products) {
        return products.stream()
                .map(ProductDto::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
