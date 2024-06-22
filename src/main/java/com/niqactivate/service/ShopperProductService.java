package com.niqactivate.service;

import com.niqactivate.dto.ShopperProductDTO;
import com.niqactivate.entity.ShopperProduct;
import com.niqactivate.mapper.ShopperProductMapper;
import com.niqactivate.repository.ShopperProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopperProductService {

    @Autowired
    private ShopperProductRepository repository;

    public void saveShopperProductList(List<ShopperProductDTO> shopperProductDTOs) {
        List<ShopperProduct> shopperProducts = shopperProductDTOs.stream()
            .map(ShopperProductMapper.INSTANCE::toEntity)
            .collect(Collectors.toList());
        repository.saveAll(shopperProducts);
    }

    public List<ShopperProductDTO> getProductsByShopperId(String shopperId) {
        List<ShopperProduct> products = repository.findByShopperId(shopperId);
        return products.stream()
            .map(ShopperProductMapper.INSTANCE::toDTO)
            .collect(Collectors.toList());
    }

    public List<ShopperProductDTO> getFilteredProducts(String shopperId, List<String> productIds) {
        List<ShopperProduct> products = repository.findByShopperIdAndProductIdIn(shopperId, productIds);
        return products.stream()
            .map(ShopperProductMapper.INSTANCE::toDTO)
            .collect(Collectors.toList());
    }
}
