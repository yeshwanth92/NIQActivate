package com.niqactivate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niqactivate.entity.ShopperProduct;

@Repository
public interface ShopperProductRepository extends JpaRepository<ShopperProduct, Long> {

	  List<ShopperProduct> findByShopperId(String shopperId);
  
	  List<ShopperProduct> findByShopperIdAndProductIdIn(String shopperId, List<String> productIds);

}
