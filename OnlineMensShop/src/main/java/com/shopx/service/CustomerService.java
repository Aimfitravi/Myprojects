package com.shopx.service;

import java.util.List;

import com.shopx.dto.LoginDTO;
import com.shopx.dto.SignUpDTO;
import com.shopx.entities.User;



public interface CustomerService {

	public User newCustomerRegistration(SignUpDTO newCustomer);
	
	public List<User> getAllCustomerDetails();
	
	public User getCustomerById(Long id);
	
	public User loginValidationForm(LoginDTO login);
	
	public User editCustomerProfil(SignUpDTO editCustomer);
}
