package com.shopx.dto;

import com.shopx.entities.CategoryType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ProductResponseDTO {

	private Long id;
	
	private String productName;
	
	private String description;
	
	private double price;
	
	private CategoryType category;

	private int quantity;
	
	private byte[] image;
	
	
}
