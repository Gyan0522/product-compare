package com.example.productcomparison.controller;

import com.example.productcomparison.exception.ProductEcommNotFoundException;
import com.example.productcomparison.model.ProductsEcomm.ProductsEcomm;
import com.example.productcomparison.repository.ProductsEcomm.ProductsEcommRepository;

import com.example.productcomparison.model.ProductsRetail.ProductsRetail;
import com.example.productcomparison.repository.ProductsRetail.ProductsRetalRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1")
class ProductController {

	private final ProductsEcommRepository productecommrepository;

	private final ProductsRetalRepository productretailrepository;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	ProductController(ProductsEcommRepository productecommrepository, ProductsRetalRepository productretailrepository) {
		this.productecommrepository = productecommrepository;
		this.productretailrepository = productretailrepository;
	}

	@GetMapping("productlisting")
	ResponseEntity<List<ProductsEcomm>> getallProductComparisons() {

		List<ProductsEcomm> listProductComparison = productecommrepository.findAll();

		if (listProductComparison.size() == 0) {
			throw new ProductEcommNotFoundException();
		}

		return ResponseEntity.ok().body(listProductComparison);
	}

	@GetMapping(path = "/product")
	ResponseEntity<String> getallStatistics(@RequestParam(required = true) String productName,
			@RequestParam(required = true) String category) {

		log.info("Searching for product name " + productName + " and product category " + category);

		ProductsEcomm resultproductEcomm = new ProductsEcomm();
		ProductsRetail resultproductRetail = new ProductsRetail();

		// List<?> resultproductEcomm = null;
		// List<?> resultproductRetail = null;
		String productRespStr = null;
		if (productName != null && category != null) {

			resultproductEcomm = productecommrepository.searchByproductandcategory(productName, category);

			log.info("Returned the comparative list of product with their category resultproductEcomm"
					+ resultproductEcomm);

			resultproductRetail = productretailrepository.searchByproductandcategory(productName, category);

			log.info("Returned the comparative list of product with their category resultproductRetail",
					resultproductRetail);

		}

		ObjectMapper mapper = new ObjectMapper();

		try {

			productRespStr = mapper.writeValueAsString(resultproductEcomm);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		
		  if ( resultproductEcomm == null) { 
		  
		  return ResponseEntity.ok().body("{Product not found in Ecomm website}");
		  
		  }else {
			  
			  return ResponseEntity.ok().body(productRespStr);
		  }

		
	}

	@PutMapping("/productsEcomm")
	String newProductEcomm(@RequestBody ProductsEcomm newProductComparison) {
		String returnCode = null;
		String productName = newProductComparison.getProductName();
		String category = newProductComparison.getCategory();

		ProductsEcomm existingProductComparison = productecommrepository.findByproductandcategory(productName,
				category);

		if (((ProductsEcomm) existingProductComparison) != null) {

			((ProductsEcomm) existingProductComparison).setProductId(newProductComparison.getProductId());
			((ProductsEcomm) existingProductComparison).setProductName(newProductComparison.getProductName());
			((ProductsEcomm) existingProductComparison).setProductPrice(newProductComparison.getProductPrice());
			((ProductsEcomm) existingProductComparison)
					.setProductDiscountedPrice(newProductComparison.getProductDiscountedPrice());
			((ProductsEcomm) existingProductComparison).setCategory(newProductComparison.getCategory());

			if (productecommrepository.save(existingProductComparison) != null) {
				returnCode = ProductsEcomm.updated(HttpStatus.CREATED);
			}

		} else {
			if (productecommrepository.save(newProductComparison) != null) {
				returnCode = ProductsEcomm.created(HttpStatus.CREATED);
			}
		}

		return returnCode;
	}

	@PutMapping("/productsRetail")
	String newProductRetail(@RequestBody ProductsRetail newProductRetail) {
		String returnCode = null;
		String productName = newProductRetail.getProductName();
		String category = newProductRetail.getCategory();

		ProductsRetail existingProductComparison = productretailrepository.findByproductandcategory(productName,
				category);

		if (((ProductsRetail) existingProductComparison) != null) {

			((ProductsRetail) existingProductComparison).setProductId(newProductRetail.getProductId());
			((ProductsRetail) existingProductComparison).setProductName(newProductRetail.getProductName());
			((ProductsRetail) existingProductComparison).setProductPrice(newProductRetail.getProductPrice());
			((ProductsRetail) existingProductComparison)
					.setProductDiscountedPrice(newProductRetail.getProductDiscountedPrice());
			((ProductsRetail) existingProductComparison).setCategory(newProductRetail.getCategory());

			if (productretailrepository.save(existingProductComparison) != null) {
				returnCode = ProductsEcomm.updated(HttpStatus.CREATED);
			}

		} else {
			if (productretailrepository.save(newProductRetail) != null) {
				returnCode = ProductsEcomm.created(HttpStatus.CREATED);
			}
		}

		return returnCode;
	}
}
