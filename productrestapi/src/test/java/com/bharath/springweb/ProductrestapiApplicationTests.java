package com.bharath.springweb;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.bharath.springweb.entity.Product;

import static org.junit.Assert.*;

import org.junit.Test;
@SpringBootTest
public class ProductrestapiApplicationTests {

	//getting the required object by provoiding its id
	@Test
	public void testGetProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject("http://localhost:3000/product/1", Product.class);
		assertNotNull(product);
		assertEquals("IPhone",product.getName());
		
	}
	
	//creating a product
	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("OnePluse");
		product.setDescription("My new Phone");
		product.setPrice(21000);
		Product newProduct = restTemplate.postForObject("http://localhost:3000/product/", product , Product.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("OnePluse",newProduct.getName());
	}
	
	//updating the record
	/*@Test
	public void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject("http://localhost:3000/product/4", Product.class);
		product.setName("Micromax");
		restTemplate.put("http://localhost:3000/product/",product);
		
	}*/
	
	

}
