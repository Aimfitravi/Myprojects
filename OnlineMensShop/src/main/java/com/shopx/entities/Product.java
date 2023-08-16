package com.shopx.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends BaseEntity{

	@Column(length = 100,nullable = false)
	private String productName;
	@Column(length = 500,nullable = false)
	private String description;
	@Range(min = 0)
	private double price;
	
	@Enumerated(EnumType.STRING)
	private CategoryType category;

	private int quantity;
	@Column(length = 300)
	private String imagePath;
	
	
}
