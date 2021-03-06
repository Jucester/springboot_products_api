package com.example.product_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Product {

    private final UUID id;
    @NotBlank
    private final String name;

    public Product(@JsonProperty("id") UUID id,
                   @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
