package com.seu.mvc.controller;

import com.seu.mvc.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("api/v1/categories")
public class CategoryController {
    @Operation(summary = "Get All Categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categories retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters",
                    content = @Content(mediaType = "text/plain", schema = @Schema(type = "string"))),
            @ApiResponse(responseCode = "404", description = "Categories not found",
                    content = @Content)
    })

    @GetMapping
    Map<String,Object> findCategories(){
        Map<String,Object> data = new HashMap<>();
        data.put("message","Catagories have found");
        data.put("data", List.of("Mengseu","Thyda","Sokny","Taing Ey","Vipha","Lyman"));
        return data;
    }
}
