package com.niqactivate.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niqactivate.dto.ProductMetadataDTO;
import com.niqactivate.dto.ShopperProductDTO;
import com.niqactivate.service.ProductMetadataService;
import com.niqactivate.service.ShopperProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/external")
@Tag(name = "External API", description = "Operations for external eCommerce interfaces")
public class ExternalController {

    @Autowired
    private ShopperProductService shopperProductService;

    @Autowired
    private ProductMetadataService productMetadataService;

    @GetMapping("/products")
    @Operation(summary = "Get Products by Shopper", description = "Get personalized products for a shopper with optional filters")
    public ResponseEntity<List<ShopperProductDTO>> getProductsByShopper(@RequestParam String shopperId,
                                                                        @RequestParam(required = false) String category,
                                                                        @RequestParam(required = false) String brand,
                                                                        @RequestParam(defaultValue = "10") int limit) {
        List<ShopperProductDTO> products = shopperProductService.getProductsByShopperId(shopperId);

        if (category != null || brand != null) {
            List<ProductMetadataDTO> filteredMetadata = productMetadataService.getFilteredProducts(category, brand);
            List<String> productIds = filteredMetadata.stream().map(ProductMetadataDTO::getProductId).collect(Collectors.toList());
            products = shopperProductService.getFilteredProducts(shopperId, productIds);
        }	

        products = products.stream()
                .sorted(Comparator.comparingDouble(ShopperProductDTO::getRelevancyScore).reversed())
                .limit(Math.min(limit, 100))
                .collect(Collectors.toList());

        return ResponseEntity.ok(products);
    }
}
