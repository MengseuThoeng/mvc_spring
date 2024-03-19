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
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createNewProduct(@RequestBody ProductCreateRequest request){
        productService.createNewProduct(request);
    }
    @PutMapping("/{uuid}")
    void editProductByUuid(@PathVariable String uuid, @RequestBody ProductEditRequest request){
        productService.editProductByUuid(request,uuid);
    }
    @GetMapping
    Map<String, Object> findProducts(@RequestParam(required = false, defaultValue = "") String name,
                                     @RequestParam(required = false, defaultValue = "true") Boolean status) {
        return Map.of(
                "message", "Products have been found",
                "data", productService.findProducts(name, status)
        );
    }

    @GetMapping("/{id}")
    Map<String,Object> findProductById(@PathVariable Integer id){
        return Map.of(
                "data",productService.findProductById(id)
        );
    }

}
