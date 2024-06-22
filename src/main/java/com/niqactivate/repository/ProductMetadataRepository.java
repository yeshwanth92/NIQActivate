package com.niqactivate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niqactivate.entity.ProductMetadata;

@Repository
public interface ProductMetadataRepository extends JpaRepository<ProductMetadata, Long> {
	
    List<ProductMetadata> findByCategoryAndBrand(String category, String brand);
    
}

