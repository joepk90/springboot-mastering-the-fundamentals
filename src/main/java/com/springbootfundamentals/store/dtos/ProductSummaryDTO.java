package com.springbootfundamentals.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductSummaryDTO {
    private Long id;
    private String name;

    // public ProductSummaryDTO(Long id, String name) {
    //     this.id = id;
    //     this.name = name;
    // }

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }
}
