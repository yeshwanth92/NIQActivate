package com.niqactivate.service;

import com.niqactivate.dto.ProductMetadataDTO;
import com.niqactivate.entity.ProductMetadata;
import com.niqactivate.mapper.ProductMetadataMapper;
import com.niqactivate.repository.ProductMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMetadataService {

    @Autowired
    private ProductMetadataRepository repository;

    public void saveProductMetadata(ProductMetadataDTO metadataDTO) {
        ProductMetadata metadata = ProductMetadataMapper.INSTANCE.toEntity(metadataDTO);
        repository.save(metadata);
    }

    public List<ProductMetadataDTO> getFilteredProducts(String category, String brand) {
        List<ProductMetadata> products = repository.findByCategoryAndBrand(category, brand);
        return products.stream()
            .map(ProductMetadataMapper.INSTANCE::toDTO)
            .collect(Collectors.toList());
    }
}
