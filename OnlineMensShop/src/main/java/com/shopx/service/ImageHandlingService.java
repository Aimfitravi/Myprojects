package com.shopx.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageHandlingService {

//add a method to upload binary content to server side folder
	//1st arg: emp id
	//2nd arg: represent uploaded file contents received in multipart request
	String uploadImage(Long productId, MultipartFile file) throws IOException;
	byte[] downloadImage(Long empId) throws IOException;
}
