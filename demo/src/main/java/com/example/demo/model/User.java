package com.example.demo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("users")
@Data
public class User {
    public static final String ID_COLUMN_NAME = "id";
    public static final String NAME_COLUMN_NAME = "name";
    public static final String SURNAME_COLUMN_NAME = "surname";
    public static final String AGE_COLUMN_NAME = "age";

    @Field(ID_COLUMN_NAME)
    private Integer id;
    @Field(NAME_COLUMN_NAME)
    private String name;
    @Field(SURNAME_COLUMN_NAME)
    private String surname;
    @Field(AGE_COLUMN_NAME)
    private Integer age;
}
