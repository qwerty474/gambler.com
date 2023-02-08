package com.gambler.service.product.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Product {
    private Integer id;
    private String name;
    private Integer ownerId;
}
