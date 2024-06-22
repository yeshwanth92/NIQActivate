package com.niqactivate.controller;

import com.niqactivate.dto.ProductMetadataDTO;
import com.niqactivate.dto.ShopperProductDTO;
import com.niqactivate.service.ProductMetadataService;
import com.niqactivate.service.ShopperProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal")
@Tag(name = "Internal API", description = "Operations for internal data management")
public class InternalController {

    @Autowired
    private ShopperProductService shopperProductService;

    @Autowired
    private ProductMetadataService productMetadataService;

    @PostMapping("/shopper-products")
    @Operation(summary = "Add Shopper Products", description = "Add a list of personalized shopper products")
    public ResponseEntity<?> addShopperProducts(@RequestBody List<ShopperProductDTO> shopperProducts) {
        shopperProductService.saveShopperProductList(shopperProducts);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/product-metadata")
    @Operation(summary = "Add Product Metadata", description = "Add metadata for a product")
    public ResponseEntity<?> addProductMetadata(@RequestBody ProductMetadataDTO metadataDTO) {
        productMetadataService.saveProductMetadata(metadataDTO);
        return ResponseEntity.ok().build();
    }
}
