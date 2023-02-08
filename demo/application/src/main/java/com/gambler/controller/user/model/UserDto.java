package com.gambler.controller.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class UserDto implements Serializable {
    private Integer id;
    private String name;
    private String lastname;
    private List<UserProductDto> products;

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class UserProductDto implements Serializable {
        private Integer id;
        private String name;
    }
}
