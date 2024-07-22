package org.blackstone.retail.domain.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {

    private long userId;
    private BigDecimal subTotal = BigDecimal.ZERO;
    private BigDecimal tax = BigDecimal.valueOf(0.05);
    private BigDecimal totalBillAmount = BigDecimal.ZERO;
    private BigDecimal discountAmount = BigDecimal.ZERO;
    private BigDecimal payableAmount = BigDecimal.ZERO;
//    private List<DiscountStrategy> discountStrategies;
    private List<ProductDto> products = new ArrayList<>();
}
