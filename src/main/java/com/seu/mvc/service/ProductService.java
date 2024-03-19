package com.seu.mvc.service;

import com.seu.mvc.dto.ProductCreateRequest;
import com.seu.mvc.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> findProducts();
    ProductResponse findProductById (Integer id);
    ProductResponse findProductByName (String name);
    void createNewProduct(ProductCreateRequest productCreateRequest);
}
