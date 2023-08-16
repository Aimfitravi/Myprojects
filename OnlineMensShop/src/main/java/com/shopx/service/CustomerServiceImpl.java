package com.shopx.service;

import java.util.List;
import java.util.NoSuchElementException;
import com.shopx.custom_exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopx.dao.CustomerDao;
import com.shopx.dto.LoginDTO;
import com.shopx.dto.SignUpDTO;
import com.shopx.entities.User;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao dao;
	
	@Autowired
	private ModelMapper mapper;
	
	//Registration or creating new customer
	@Override
	public User newCustomerRegistration(SignUpDTO newCustomer) {
		User customer = dao.save(mapper.map(newCustomer, User.class));		
		return customer;
	}

	//Finding all customer details
	@Override
	public List<User> getAllCustomerDetails() {
		return dao.findAll();
	}

	@Override
	public User getCustomerById(Long id) {
		
		return dao.findById(id).orElseThrow(()->new NoSuchElementException("Invalid Customer Id"));
	}

	@Override
	public User loginValidationForm(LoginDTO login) {
		return dao.findByEmailAndPassword(login.getEmail(), login.getPassword()).
				orElseThrow(() -> new ResourceNotFoundException("Invalid Credentials , User not found!!"));
	}

//	@Override
//	public Customer editCustomerProfil(SignUpDTO editCustomer) {
//		
//		return dao.;
//	}

}
