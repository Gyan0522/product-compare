
DROP TABLE IF EXISTS PRODUCTS;
  
CREATE TABLE PRODUCTS (
  productId INT AUTO_INCREMENT  PRIMARY KEY,
  productName VARCHAR(250) NOT NULL,
  productPrice VARCHAR(250) NOT NULL,
  productDiscountedPrice VARCHAR(250) DEFAULT NULL,
  category VARCHAR(250) NOT NULL
);

INSERT INTO PRODUCTS (productName, productPrice, productDiscountedPrice, category) VALUES
  ('MANGO', '100', '80', 'FRUITS'),
  ('ONION', '45', '40', 'VEGETABLES'),
  ('RICE', '50', '48', 'GROCERY');