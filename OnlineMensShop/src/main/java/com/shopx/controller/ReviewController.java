package com.shopx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopx.dto.ReviewDTO;
import com.shopx.entities.BaseEntity;
import com.shopx.service.ReviewService;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController extends BaseEntity{
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping
	public ResponseEntity<?> addNewReview(@RequestBody ReviewDTO review)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.addNewReview(review));
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<?> getReviewByProductId(@PathVariable Long productId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(reviewService.getReviewByProductId(productId));
	}
	

	//Avgerage rating by each individual product by id
	@GetMapping("/rating/{productId}")
	public ResponseEntity<?> getAvgProductRatingById(@PathVariable Long productId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(reviewService.getAvgProductRatingById(productId));
	}
	
	
	//Avgerage rating by all product
//		@GetMapping("/avg")
//		public ResponseEntity<?> getAvgProductRatingOfAll()
//		{
//			return ResponseEntity.status(HttpStatus.OK).body(reviewService.getAvgProductRatingOfAllProducts());
//		}

	
}
