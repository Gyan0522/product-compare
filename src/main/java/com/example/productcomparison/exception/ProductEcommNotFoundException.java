package com.example.productcomparison.exception;

@SuppressWarnings("serial")
public class ProductEcommNotFoundException extends RuntimeException {

    public ProductEcommNotFoundException(String id) {
        super("No data found for " + id);
    }

    public ProductEcommNotFoundException() {
        super("Product not found in Ecomm website");
    }
}