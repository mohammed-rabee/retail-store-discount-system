package org.blackstone.retail.domain.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long productID;

    private String label;

    private String description;

    private BigDecimal price;

    private String productCode;
}
