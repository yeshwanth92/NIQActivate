package com.niqactivate.dto;

import java.time.LocalDateTime;

public class ShopperProductDTO {
    
	private String shopperId;
    
	private String productId;
    
	private double relevancyScore;
    
	private LocalDateTime createdAt;
    
	public String getShopperId() {
		return shopperId;
	}
	public void setShopperId(String shopperId) {
		this.shopperId = shopperId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getRelevancyScore() {
		return relevancyScore;
	}
	public void setRelevancyScore(double relevancyScore) {
		this.relevancyScore = relevancyScore;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
