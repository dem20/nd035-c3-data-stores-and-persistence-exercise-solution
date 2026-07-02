package com.udacity.jdnd.course3.lesson1.data;

import jakarta.persistence.Entity;

@Entity
public class Shrub extends Plant {

    private Integer height;
    private Integer width;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
