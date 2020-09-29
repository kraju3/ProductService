package com.example.product.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    @Column
    private long productID;

    @Column
    public String productName;

    @Column
    public String productImgUrl;

    @Column
    public boolean IsAvailable;

    @ManyToOne
    @JoinColumn
    private Category category;

    @Embedded
    private Detail productDetail;


    public long getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImgUrl() {
        return productImgUrl;
    }

    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }

    public boolean isAvailable() {
        return IsAvailable;
    }

    public void setAvailable(boolean available) {
        IsAvailable = available;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Detail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(Detail productDetail) {
        this.productDetail = productDetail;
    }

    public Product(String productName, String productImgUrl, boolean isAvailable, Category category, Detail productDetail) {
        this.productName = productName;
        this.productImgUrl = productImgUrl;
        IsAvailable = isAvailable;
        this.category = category;
        this.productDetail = productDetail;
    }

    public Product(){

    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productImgUrl='" + productImgUrl + '\'' +
                ", IsAvailable=" + IsAvailable +
                ", category=" + category.getCategoryName() +
                ", productDetail=" + productDetail +
                '}';
    }
}
