package org.blackstone.retail.object_mother;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.blackstone.retail.domain.dto.ProductDto;

public class ProductObjectMother {

    public static List<ProductDto> getProductList() {
        return Arrays.asList(
                new ProductDto(1L, "Laptop", "High-performance laptop", BigDecimal.valueOf(190), "LAP123"),
                new ProductDto(2L, "Headphones", "Noise-cancelling headphones", BigDecimal.valueOf(100), "HP456"),
                new ProductDto(3L, "Smartphone", "Latest model smartphone", BigDecimal.valueOf(200), "SP789"),
                new ProductDto(4L, "Desk Chair", "Ergonomic desk chair", BigDecimal.valueOf(300), "DC101"),
                new ProductDto(5L, "Coffee Maker", "Automatic coffee maker", BigDecimal.valueOf(200), "CM202")
        );
    }
}
