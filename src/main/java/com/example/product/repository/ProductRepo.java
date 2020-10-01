package com.example.product.repository;

import com.example.product.domain.Category;
import com.example.product.domain.Detail;
import com.example.product.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {


    List<Product> findByProductNameLike(String productName);

    List<Product> findByProductDetail(Detail productDetail);

    List<Product> findByCategory(Category category);

}
