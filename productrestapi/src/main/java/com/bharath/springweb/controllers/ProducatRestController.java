package com.bharath.springweb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import com.bharath.springweb.entity.Product;
import com.bharath.springweb.repos.productRepository;

@RestController
public class ProducatRestController {
	productRepository repository;
	
	 // Constructor-based injection for repository
    public ProducatRestController(productRepository repository) {
        this.repository = repository;
    }

	
	//displaying all records
	@GetMapping("/product/")
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	//Fetching only required data records, by giving id 
	@GetMapping("/product/{id}")
	public Product getSingleProduct(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	//inserting a record
	@PostMapping("/product/")
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	
	//Updating the data
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
		 product.setId(id);
		return repository.save(product);
	}
	
	//deleting a record
	@DeleteMapping("/product/{id}")
	public void deleteSingleProduct(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

}

