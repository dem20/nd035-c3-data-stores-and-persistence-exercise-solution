package com.udacity.jdnd.course3.lesson1.data.dto;

import java.math.BigDecimal;

public class PlantDTO {
    private String name;
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
