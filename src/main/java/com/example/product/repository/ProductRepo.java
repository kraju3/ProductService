package com.example.product.repository;

import com.example.product.domain.Category;
import com.example.product.domain.Detail;
import com.example.product.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends CrudRepository<Product, Long> {


    List<Product> findByProductNameLike(String productName);

    List<Product> findByProductDetail(Detail productDetail);

    List<Product> findByCategory(Category category);

}
