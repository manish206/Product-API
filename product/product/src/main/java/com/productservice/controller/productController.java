package com.productservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.Entities.product;
import com.productservice.services.productService;

@RestController
public class productController {
	@Autowired
	productService productservice;
	
	@PostMapping("/addProducts")
	public ArrayList<product> addProducts(@RequestBody ArrayList<product> products){
		return productservice.addProduct(products);
	}
	@GetMapping("/viewProducts/{sellerId}")
	public ArrayList<product> viewProducts(@PathVariable(value="sellerId") String sellerId ) {
		
		return productservice.viewProducts(sellerId);
	}
	
	@DeleteMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("sellerId") String sellerId,@RequestParam("productId") String productId) {
		System.out.println("sellerId : "+ sellerId);
		System.out.println("productId : "+ productId);
		
		return productservice.deleteProduct(productId,sellerId);
	}
	@GetMapping("/viewProducts/name/{productName}")
	public ArrayList<product> viewProductsbyname(@PathVariable(value="productName") String productName ) {
		
		return productservice.searchProductByProductName(productName);
	}
	@GetMapping("/viewProducts/type/{productType}")
	public ArrayList<product> viewProductsbytype(@PathVariable(value="productType") String productType ) {
		
		return productservice.searchProductByProductType(productType);
	}
	@GetMapping("/viewProducts/category/{productCategory}")
	public ArrayList<product> viewProductsbycategory(@PathVariable(value="productCategory") String productCategory ) {
		
		return productservice.searchProductByProductCategory(productCategory);
	}
	@GetMapping("/viewProducts/pricerange")
	public ArrayList<product> viewProductsbycategory(@RequestParam("min") double min, @RequestParam("max") double max) {
		
		return productservice.searchProductByProductByPrice(min,max);
	}
	
	
}
