package com.example.product.service;

import com.example.product.domain.Product;
import com.example.product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
@Service
public class ProductService {

    private ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @GetMapping(path="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable(value="id") long productID){

        return productRepo.findById(productID).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product p) {

        return productRepo.save(p);
    }


    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable(value = "id") long productID) {
        productRepo.findById(productID).ifPresent(product -> {
            productRepo.delete(product);
        });
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@PathVariable(value = "id") long productID, @RequestBody Product product) {
        productRepo.findById(productID).ifPresent(product1 -> {
            product1.setAvailable(product.isAvailable());
            product1.setCategory(product.getCategory());
            product1.setProductDetail(product.getProductDetail());
            product1.setProductImgUrl(product.getProductImgUrl());

            productRepo.save(product1);
        });


        return productRepo.findById((productID)).get();

    }

}
