package com.seu.mvc.dto;

public record ProductResponse(
         String uuid,
         String name,
         Double price,
         Integer qty
) {

}
