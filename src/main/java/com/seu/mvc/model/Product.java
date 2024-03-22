package com.seu.mvc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    private Integer id;
    private String uuid;
    private String name;
    private Double price;
    private Integer qty;
    private LocalDateTime importedDate;
    private Boolean status;

//    @ManyToOne
//    private Category category;
}
