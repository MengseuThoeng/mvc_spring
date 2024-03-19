package com.seu.mvc.service;

import com.seu.mvc.dto.ProductCreateRequest;
import com.seu.mvc.dto.ProductEditRequest;
import com.seu.mvc.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> findProducts(String name, Boolean status);
    ProductResponse findProductById (Integer id);
    void createNewProduct(ProductCreateRequest productCreateRequest);
    void editProductByUuid(ProductEditRequest request,String uuid);
    void deleteProductByUuid(String uuid);
}
