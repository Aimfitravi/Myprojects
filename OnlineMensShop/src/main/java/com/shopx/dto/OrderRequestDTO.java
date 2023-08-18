package com.shopx.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderRequestDTO {
	

	private Long quantity;
	
	private Long customerId;
	
	private Long productId;
}
