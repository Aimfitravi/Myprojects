package com.shopx.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity{

	@Column(length = 25)
	private String firstName;
	@Column(length = 25)
	private String lastName;
	@Column(length = 50, unique = true) 
	private String email;
	@Column(length = 50, nullable = false) // NOT NULL constraint
	private String password;	
	@Column(length = 200)
	private String address;
	@Column(length = 25)
	private String mobile;
	@Enumerated(EnumType.STRING)
	@Column(length = 25)
	private RoleType role=RoleType.ROLE_CUSTOMER;
	
	@OneToOne(mappedBy = "cartOwner",cascade = CascadeType.ALL,orphanRemoval = true)
	//@JoinColumn(name="customer_id")
	private ShoppingCart myCart;
	
	
	
	public void addCart(ShoppingCart cart)
	{
		//establish bi dir relationship
		setMyCart(cart);
		cart.setCartOwner(this);
	}
	
	
	
}
