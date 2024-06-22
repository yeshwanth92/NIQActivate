package com.niqactivate.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.niqactivate.dto.ShopperProductDTO;
import com.niqactivate.entity.ShopperProduct;

@Mapper
public interface ShopperProductMapper {
    ShopperProductMapper INSTANCE = Mappers.getMapper(ShopperProductMapper.class);

    ShopperProductDTO toDTO(ShopperProduct shopperProduct);
    ShopperProduct toEntity(ShopperProductDTO shopperProductDTO);
}
