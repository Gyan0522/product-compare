DROP TABLE IF EXISTS PRODUCTS;
  
CREATE TABLE PRODUCTS (
  productId INT AUTO_INCREMENT  PRIMARY KEY,
  productName VARCHAR(250) NOT NULL,
  productPrice VARCHAR(250) NOT NULL,
  productDiscountedPrice VARCHAR(250) DEFAULT NULL,
  category VARCHAR(250) NOT NULL
);