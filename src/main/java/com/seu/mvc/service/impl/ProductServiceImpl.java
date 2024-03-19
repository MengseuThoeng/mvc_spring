package com.seu.mvc.service.impl;

import com.seu.mvc.dto.ProductCreateRequest;
import com.seu.mvc.dto.ProductResponse;
import com.seu.mvc.model.Product;
import com.seu.mvc.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private List<Product> products;
    public ProductServiceImpl(){
        products = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("Mengseu");
        p1.setPrice(1.00);
        p1.setQty(1);
        p1.setUuid(UUID.randomUUID().toString());
        p1.setImportedDate(LocalDateTime.now());
        p1.setStatus(true);
        Product p2 = new Product();
        p2.setId(2);
        p2.setName("seu");
        p2.setPrice(1.00);
        p2.setQty(1);
        p2.setUuid(UUID.randomUUID().toString());
        p2.setImportedDate(LocalDateTime.now());
        p2.setStatus(true);
        products.add(p1);
        products.add(p2);
    }

    @Override
    public void createNewProduct(ProductCreateRequest productCreateRequest) {
        Product newProduct = new Product() ;
        newProduct.setName(productCreateRequest.name());
        newProduct.setPrice(productCreateRequest.price());
        newProduct.setQty(productCreateRequest.qty());
        newProduct.setId(products.size()+1);
        newProduct.setUuid(UUID.randomUUID().toString());
        newProduct.setImportedDate(LocalDateTime.now());
        newProduct.setStatus(true);
        products.add(newProduct);
    }

    @Override
    public List<ProductResponse> findProducts() {
        return products
                .stream()
                .filter(Product::getStatus)
                .map(product -> new ProductResponse(
                        product.getUuid(),
                        product.getName(),
                        product.getPrice(),
                        product.getQty()
                ))
                .toList();
    }

    @Override
    public ProductResponse findProductById(Integer id) {
        return products.stream()
                .filter(product -> product.getStatus() && product.getId().equals(id))
                .map(product -> new ProductResponse(
                        product.getUuid(),
                        product.getName(),
                        product.getPrice(),
                        product.getQty()
                ))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ProductResponse findProductByName(String name) {
        return products.stream()
                .filter(product -> product.getStatus() && product.getName().contains(name))
                .map(product -> new ProductResponse(
                        product.getUuid(),
                        product.getName(),
                        product.getPrice(),
                        product.getQty()
                ))
                .findFirst()
                .orElse(null);
    }

}
