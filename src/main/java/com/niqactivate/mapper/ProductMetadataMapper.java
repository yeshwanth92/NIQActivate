package com.niqactivate.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.niqactivate.dto.ProductMetadataDTO;
import com.niqactivate.entity.ProductMetadata;

@Mapper
public interface ProductMetadataMapper {
    ProductMetadataMapper INSTANCE = Mappers.getMapper(ProductMetadataMapper.class);

    ProductMetadataDTO toDTO(ProductMetadata productMetadata);
    ProductMetadata toEntity(ProductMetadataDTO productMetadataDTO);
}
