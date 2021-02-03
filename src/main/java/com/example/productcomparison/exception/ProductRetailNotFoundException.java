package com.example.productcomparison.exception;

@SuppressWarnings("serial")
public class ProductRetailNotFoundException extends RuntimeException {

    public ProductRetailNotFoundException(String id) {
        super("No data found for " + id);
    }

    public ProductRetailNotFoundException() {
        super("Product not found in Retail Store");
    }
}