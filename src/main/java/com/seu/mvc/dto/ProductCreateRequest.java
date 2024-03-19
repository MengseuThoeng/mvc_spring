package com.seu.mvc.dto;

public record ProductCreateRequest(
        String name,
        Double price,
        Integer qty
) {

}
