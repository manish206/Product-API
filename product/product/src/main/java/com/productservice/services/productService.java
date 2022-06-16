package com.productservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.productservice.Entities.product;
import com.productservice.repository.productRepository;

@Service
@Component
public class productService {
	@Autowired
	productRepository prodRep;

	public ArrayList<product> addProduct(ArrayList<product> products) {
		// TODO Auto-generated method stub
	
		prodRep.saveAll(products);
		return products;
	}

	public ArrayList<product> viewProducts(String sellerId) {
		// TODO Auto-generated method stub
		return prodRep.findBySellerId(sellerId);
	}
	public String deleteProduct(String productId, String sellerId) {
		System.out.println("sellerId : "+ sellerId + sellerId.getClass());
		System.out.println("productId : "+ productId+ productId.getClass());
		product p=prodRep.findById(productId).get();
		System.out.println("P : " + p);
		String x=null;
		if(p.getSellerId().equals(sellerId)) {
			prodRep.deleteById(productId);
			x="Product deleted succesfully";
		}
		else {
			x= "product does not belongs to this seller";
		}
		return x;
	}
	public String updateProduct(product p) {
		if(prodRep.findById(p.getProductId()).get().equals(p.getSellerId())) {
			prodRep.save(p);
			return "Product Updated Succesfully";
		}
		else {
			return "Failed to updated Product";
		}
	}
	public ArrayList<product> searchProductByProductName(String productName){
		return prodRep.findByProductName(productName);
	}
	public ArrayList<product> searchProductByProductType(String productType){
		return prodRep.findByProductType(productType);
	}
	public ArrayList<product> searchProductByProductCategory(String productCategory){
		return prodRep.findByProductCategory(productCategory);
	}

	public ArrayList<product> searchProductByProductByPrice(double min, double max) {
		// TODO Auto-generated method stub
		ArrayList<product> products=new ArrayList<product>();
		ArrayList<product> productlist=(ArrayList<product>) prodRep.findAll();
		System.out.println(products);
		for(product p:productlist) {
			if(p.getProductPrice() <= max && p.getProductPrice() >= min) {
				products.add(p);
			}
		}
		System.out.println(products);
		return products;
	}
	

}
