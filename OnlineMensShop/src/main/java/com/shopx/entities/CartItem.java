package com.shopx.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * CartItem :   id,int quantity,double totalPrice(=product unit price * quantity)

   
    private ShoppingCart cart;

    
    private Product product;
 */
@Entity
@Table(name = "cart_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem extends BaseEntity {
	private int quantity;
	private double totalPrice;
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private ShoppingCart myCart;
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
