package com.example.product.repository;

import com.example.product.domain.Category;
import com.example.product.domain.Detail;
import com.example.product.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepo extends CrudRepository<Product, Long> {


    List<Product> findByProductNameLike(String productName);

    List<Product> findByProductDetail(Detail productDetail);

    List<Product> findByCategory(Category category);

    @Override
    default <S extends Product> S save(S s) {
        return null;
    }

    @Override
    default <S extends Product> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    default Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default Iterable<Product> findAll() {
        return null;
    }

    @Override
    default Iterable<Product> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(Product product) {

    }

    @Override
    default void deleteAll(Iterable<? extends Product> iterable) {

    }

    @Override
    default void deleteAll() {

    }
}
