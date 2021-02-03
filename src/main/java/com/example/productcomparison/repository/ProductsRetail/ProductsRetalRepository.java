package com.example.productcomparison.repository.ProductsRetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.productcomparison.model.ProductsRetail.*;

import java.util.List;

public interface ProductsRetalRepository extends JpaRepository<ProductsRetail, Integer> {

	@Query("select u from ProductsRetail u where u.productName =?1 and u.category =?2")
	ProductsRetail searchByproductandcategory(String productName, String category);

	@Query("select u from ProductsRetail u where u.productName =?1 and u.category =?2 ")
	ProductsRetail findByproductandcategory(String productName, String category);

}