package com.example.productcomparison.repository.ProductsEcomm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.productcomparison.model.ProductsEcomm.*;

import java.util.List;

public interface ProductsEcommRepository extends JpaRepository<ProductsEcomm, Integer> {

	@Query("select u from ProductsEcomm u where u.productName =?1 and u.category =?2")
	ProductsEcomm searchByproductandcategory(String productName, String category);

	@Query("select u from ProductsEcomm u where u.productName =?1 and u.category =?2 ")
	ProductsEcomm findByproductandcategory(String productName, String category);

}