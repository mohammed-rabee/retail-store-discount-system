package org.blackstone.retail;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.blackstone.retail.domain.dto.CartDto;
import org.blackstone.retail.service.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discount")
public class DiscountController {

    private final DiscountService discountService;

    @PostMapping("/calculate")
    public ResponseEntity<BigDecimal> getEmployeeDiscount(@RequestBody CartDto cartDto) {

        return ResponseEntity.ok(discountService.applyDiscount(cartDto));
    }
}
