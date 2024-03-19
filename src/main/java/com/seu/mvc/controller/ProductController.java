package com.seu.mvc.controller;
import com.seu.mvc.dto.ProductCreateRequest;
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

    @GetMapping
    Map<String,Object> findProducts(){
        return Map.of(
                "date",productService.findProducts()
        );
    }
    @GetMapping("/{id}")
    Map<String,Object> findProductById(@PathVariable Integer id){
        return Map.of(
                "data",productService.findProductById(id)
        );
    }

}
