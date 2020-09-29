package com.example.product;

import com.example.product.domain.Category;
import com.example.product.domain.Detail;
import com.example.product.domain.Product;
import com.example.product.repository.CategoryRepository;
import com.example.product.repository.ProductRepo;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  ProductApplication implements CommandLineRunner {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryRepository categoryRepository;



	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			createProducts();

	}

	private void createProducts(){

		boolean available = true;
		Category shirt = categoryRepository.save(new Category("Shirts"));
		Category pant = categoryRepository.save(new Category("Pants"));
		Category shoes = categoryRepository.save(new Category("Shoes"));
		Category accessories = categoryRepository.save(new Category("Accessories"));

		productService.createProduct(new Product("Nylon Shirt","src/asserts/shirt.png",available,shirt,new Detail("A shirt",5,5,5,5)));
		productService.createProduct(new Product("Nylon Shirt","src/asserts/shirt.png",available,shirt,new Detail("A shirt",5,5,5,5)));
		productService.createProduct(new Product("Nylon Pants","src/asserts/pants.png",available,pant,new Detail("A shirt",5,5,5,5)));
		productService.createProduct(new Product("Normal Pants","src/asserts/ptamts.png",available,pant,new Detail("A shirt",5,5,5,5)));
		productService.createProduct(new Product("Nike Air Max","src/asserts/shoes.png",available,shoes, new Detail("A Nike classic Air Max Shoe",100,105,5,5)));
		productService.createProduct(new Product("Nike Air Max","src/asserts/shoes.png",available,shoes, new Detail("A Nike classic Air Max Shoe",100,105,5,5)));
		productService.createProduct(new Product("Movado Fade","src/asserts/watch.png",available,accessories, new Detail("A watch",6,5,5,5)));
		productService.createProduct(new Product("Timex","src/asserts/shirt.png",available,accessories,new Detail("A shirt",5,5,5,5)));




	}
}
