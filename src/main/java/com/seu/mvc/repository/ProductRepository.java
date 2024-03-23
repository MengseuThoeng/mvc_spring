package com.seu.mvc.repository;

import com.seu.mvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    boolean existsByUuid (String uuid);
    void deleteByUuid(String uuid);
    Product findByUuid(String uuid);
}
