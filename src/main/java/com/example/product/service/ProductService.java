package com.example.product.service;

import com.example.product.domain.Product;
import com.example.product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    private ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProduct(long productID){

        return productRepo.findById(productID).orElseThrow();
    }

    public void createProduct(Product p) {
        productRepo.save(p);
    }


    public void deleteProduct(long productID) {
        productRepo.deleteById(productID);
    }

    public Product updateProduct(long productID,Product product) {
        productRepo.findById(productID).ifPresent(product1 -> {
            product1.setAvailable(product.isAvailable());
            product1.setCategory(product.getCategory());
            product1.setProductDetail(product.getProductDetail());
            product1.setProductImgUrl(product.getProductImgUrl());

            productRepo.save(product1);
        });


        return productRepo.findById((productID)).get();

    }

    public boolean verify(long productID){
        return productRepo.existsById(productID);
    }




}
