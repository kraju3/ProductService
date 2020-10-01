package com.example.product.web;

import com.example.product.domain.Detail;
import com.example.product.domain.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody @Validated Product product) {

        productService.createProduct(product);


    }
    @PutMapping(path="/{productID}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable(value="productID")long productID,@RequestBody @Validated Product p){
       if(productService.verify(productID)){
           productService.updateProduct(productID,p);
       }
    }

    @DeleteMapping(path="/{productID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable(value="productID") long productID){
        if(productService.verify(productID)){
            productService.deleteProduct(productID);
        }
    }

    @GetMapping(path="/{productID}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable(value="productID") long productID){
        return productService.verify(productID)?productService.getProduct(productID):new Product();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/details/{productID}")
    @ResponseStatus(HttpStatus.OK)
    public Detail getProductDetail(@PathVariable(value="productID") long productID){
        return productService.verify(productID)? productService.getProduct(productID).getProductDetail():new Detail();
    }

    @GetMapping("/details")
    @ResponseStatus(HttpStatus.OK)
    public Map<Long,Detail> getProductsDetails(){
        Map<Long,Detail> productsDetails = new HashMap<>();
        productService.getAllProducts().forEach(product -> {
            productsDetails.put(product.getProductID(),product.getProductDetail());
        });

        return productsDetails;
    }

}
