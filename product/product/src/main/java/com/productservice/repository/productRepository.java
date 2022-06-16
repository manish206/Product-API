package com.productservice.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.productservice.Entities.product;


@Repository
@Component
public interface productRepository extends CrudRepository<product,String>{
	ArrayList<product> findBySellerId(String sellerId);
	ArrayList<product> findByProductName(String productName);
	ArrayList<product> findByProductType(String productType);
	ArrayList<product> findByProductCategory(String productCategory);
	/* product findByProductId(String productId); */
}
