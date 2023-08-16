package com.shopx.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopx.dto.LoginDTO;
import com.shopx.dto.SignUpDTO;
import com.shopx.entities.User;
//import com.shopx.service.CustomerService;
import com.shopx.service.CustomerService;

import lombok.val;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<?> newCustomerRegistration(@RequestBody @Valid SignUpDTO newCustomer)
	{
		User customer = customerService.newCustomerRegistration(newCustomer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCustomerDetails()
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomerDetails());
	}
	
	@GetMapping("/{custId}")
	public ResponseEntity<?> getCustomerById(Long custId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.getCustomerById(custId));
	}
	
	@PostMapping
	public ResponseEntity<?> loginValidationForm(@RequestBody @Valid LoginDTO login)
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.loginValidationForm(login));
	}
	
//	@PutMapping
//	public ResponseEntity<?> editCustomerProfil(@RequestBody @Valid SignUpDTO customer)
//	{
//		
//	}
//	
	
	
	

}
