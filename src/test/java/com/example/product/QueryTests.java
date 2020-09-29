package com.example.product;

import com.example.product.domain.Category;
import com.example.product.domain.Detail;
import com.example.product.domain.Product;
import com.example.product.repository.CategoryRepository;
import com.example.product.repository.ProductRepo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryTests {

    @Autowired
    ProductRepo productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void testQuery(){
        boolean available = true;
        Category shirt = categoryRepository.save(new Category("Shirts"));
        Category pant = categoryRepository.save(new Category("Pants"));
        Category shoes = categoryRepository.save(new Category("Shoes"));
        Category accessories = categoryRepository.save(new Category("Accessories"));

        productRepository.save(new Product("Nylon Shirt","src/asserts/shirt.png",available,shirt,new Detail("A shirt",5,5,5,5)));
        productRepository.save(new Product("Cotton Shirt","src/asserts/shirt.png",!available,shirt,new Detail("A shirt",5,5,5,5)));

        productRepository.save(new Product("Nylon Pant","src/asserts/pants.png",available,pant, new Detail("A pant",6,5,5,5)));
        productRepository.save(new Product("Sweatpants","src/asserts/pants.png",!available,pant,new Detail("A pant",5,5,5,5)));

        Product p = productRepository.save(new Product("Nike Air Max","src/asserts/shoes.png",available,shoes, new Detail("A Nike classic Air Max Shoe",100,105,5,5)));
        productRepository.save(new Product("Adidas Yeezy","src/asserts/shoes.png",!available,shoes,new Detail("A Kanye West Tribute",509,5,5,5)));

        productRepository.save(new Product("Movado Fade","src/asserts/watch.png",available,accessories, new Detail("A watch",6,5,5,5)));
        productRepository.save(new Product("Timex","src/asserts/pants.png",!available,accessories,new Detail("A watch",5,5,5,5)));

        List<Product> searchProducts = productRepository.findByProductName("Timex");

        searchProducts.forEach(System.out::println);

        assertTrue(searchProducts.size()==2);

        Detail productDetail = productRepository.findById(p.getProductID()).get().getProductDetail();

        assertEquals(100,productDetail.getSmallCount());


    }
}
