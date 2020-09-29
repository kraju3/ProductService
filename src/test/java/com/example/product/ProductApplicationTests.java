package com.example.product;

import com.example.product.domain.Category;
import com.example.product.domain.Detail;
import com.example.product.domain.Product;
import com.example.product.repository.CategoryRepository;
import com.example.product.repository.ProductRepo;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductApplicationTests {

	@Autowired
	ProductRepo productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void simpleCrudTest(){
		boolean available = true;
		Category shirt = categoryRepository.save(new Category("Shirts"));
		Category pant = categoryRepository.save(new Category("Pants"));



		productRepository.save(new Product("Nylon Shirt","src/asserts/shirt.png",available,shirt,new Detail("A shirt",5,5,5,5)));
		productRepository.save(new Product("Cotton Shirt","src/asserts/shirt.png",available,shirt,new Detail("A shirt",5,5,5,5)));
		productRepository.save(new Product("Nylon Pant","src/asserts/pants.png",available,pant, new Detail("A pant",6,5,5,5)));
		productRepository.save(new Product("Sweatpants","src/asserts/pants.png",!available,pant,new Detail("A pant",5,5,5,5)));

		System.out.println("\n****Original List of Products*****");

		productRepository.findAll().forEach(System.out::println);

		assertEquals("Nylon Pant",productRepository.findById(5L).get().productName);
		assertEquals(available,productRepository.findById(5L).get().isAvailable());
		assertEquals("Pants",productRepository.findById(5L).get().getCategory().getCategoryName());
		assertEquals("A pant",productRepository.findById(5L).get().getProductDetail().getDescription());
		assertEquals(6,productRepository.findById(5L).get().getProductDetail().getSmallCount());

	}

}
