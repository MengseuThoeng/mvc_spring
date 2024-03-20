package com.seu.mvc.controller;
import com.seu.mvc.dto.ProductCreateRequest;
import com.seu.mvc.dto.ProductEditRequest;
import com.seu.mvc.dto.ProductResponse;
import com.seu.mvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping//Create
    @ResponseStatus(HttpStatus.CREATED)
    void createNewProduct(@RequestBody ProductCreateRequest request){
        productService.createNewProduct(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")//Delete
    void deleteByUuid(@PathVariable String uuid){
        productService.deleteProductByUuid(uuid);
    }

    @PutMapping("/{uuid}")//Update
    void editProductByUuid(@PathVariable String uuid, @RequestBody ProductEditRequest request){
        productService.editProductByUuid(request,uuid);
    }
    @GetMapping//Find Product
    Map<String, Object> findProducts(@RequestParam(required = false, defaultValue = "") String name,
                                     @RequestParam(required = false, defaultValue = "true") Boolean status) {
        return Map.of(
                "message", "Products have been found",
                "data", productService.findProducts(name, status)
        );
    }

    @GetMapping("/{id}")//Find by ID
    Map<String,Object> findProductById(@PathVariable Integer id){
        return Map.of(
                "data",productService.findProductById(id)
        );
    }

}
