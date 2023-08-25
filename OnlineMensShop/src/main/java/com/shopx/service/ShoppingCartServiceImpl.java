package com.shopx.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopx.custom_exception.ResourceNotFoundException;
import com.shopx.dao.CartItemRepository;
import com.shopx.dao.ProductDao;
import com.shopx.dao.ShoppingCartRepository;
import com.shopx.dto.CartResponseDTO;
import com.shopx.entities.CartItem;
import com.shopx.entities.Product;
import com.shopx.entities.ShoppingCart;
import com.shopx.entities.User;



@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {
	// dep
	@Autowired
	private ShoppingCartRepository cartRepo;
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartItemRepository cartItemRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public String addProductToCart(long userId, long prodId, int quantity) {
		// get user cart
		User cust = customerService.getCustomerById(userId);
		
		if(cust.getMyCart()==null)
		{
			ShoppingCart newCart = new ShoppingCart();
			cust.addCart(newCart);
		}
		
		ShoppingCart cart = cartRepo.findByCartOwnerId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Not found!!!!!!!!"));

		// cart found
		// get product details from product id
		Product product = productDao.findById(prodId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not found!!!!!!!!"));
		// Check if the cart already has the cart item for the same product id. If yes
		// simply incr the quantity , total price : update cart item : this part not yet done !
		// if not : create a cart item 
		// If any discounts/offers are going on apply discount here
		double totalItemPrice = product.getPrice() * quantity;
		CartItem newItem = new CartItem(quantity, totalItemPrice, cart, product);
		cart.getCartItems().add(newItem);
		CartItem savedItem = cartItemRepo.save(newItem);
		cart.setTotalCartPrice(cart.getTotalCartPrice() + totalItemPrice);
		cart.setTotalItems(cart.getTotalItems() + 1);
		return "Product added in the cart successfully !";
	}

	@Override
	public List<ShoppingCart> getCartDetails() {
		// get user cart
//		User customer = customerService.getCustomerById(userId);
//		 ShoppingCart cart = cartRepo.findByCartOwner(customer);
		List<ShoppingCart> j = cartRepo.getAllCart();
//		ShoppingCart cart = cartRepo.getCartWithCartItems(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("Cart Not found!!!!!!!!"));
		return j;
	}

	@Override
	public double getTotalCartPrice(long userId) {
		ShoppingCart cart = cartRepo.findByCartOwnerId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Not found!!!!!!!!"));
		return cart.getTotalCartPrice();
	}

	@Override
	public int getTotalCartItems(long userId) {
		ShoppingCart cart = cartRepo.findByCartOwnerId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Not found!!!!!!!!"));
		return cart.getTotalItems();
	}

	@Override
	public String deleteCartContents(long userId) {
		// get user cart
		ShoppingCart cart = cartRepo.getCartWithCartItems(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Not found!!!!!!!!"));
		//empty the cart here ....
		int deletedCartItems = cartItemRepo.deleteCartItems(cart.getId());
		cart.setTotalCartPrice(0);
		cart.setTotalItems(0);
		System.out.println("deleted cart items "+deletedCartItems);		
		return "user's cart emptied !!!!!";
	}

	@Override
	public List<CartResponseDTO> getAllCartItemsByCustId(Long custId) {
		
		List<CartItem> cart = cartItemRepo.findAll();
		List<CartResponseDTO> dto=new ArrayList<CartResponseDTO>();
		
		for (CartItem items : cart) {
				CartResponseDTO cartItems = mapper.map(items, CartResponseDTO.class);
				dto.add(cartItems);
		}
		return dto;
	}

}
