# Product Compare

Rest API for product comparison

Apache Maven 3.6.2 Java version: 1.8.0_181

### Steps to setup project

git clone https://github.com/Gyan0522/dealer-listing.git

cd product-compare/

- mvn install
- ./mvnw clean spring-boot:run


Build Docker image:
- mvn clean install
-	docker build --tag=product-comparison .
		
Run Docker Container:
-docker run -p 80:8080 product-comparison

#### API Endpoint :

GET

- http://localhost:80/api/v1/product?productName=Rice&category=Grocery


#### API to add data for testing

PUT

- http://localhost:80/api/v1/productsEcomm

Body:

{"productId": "101", "productName": "Rice", "productPrice": "200", "productDiscountedPrice": "185", "category": "Grocery", "source":"Ecomm" }

PUT
- http://localhost:80/api/v1/productsRetail

Body:

{"productId": "101", "productName": "Rice", "productPrice": "200", "productDiscountedPrice": "185", "category": "Grocery", "source":"Retail" }



