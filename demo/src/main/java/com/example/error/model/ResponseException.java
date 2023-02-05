package com.example.error.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Ответ фронту
 */
@Data
@Accessors(chain = true)
public class ResponseException {
    /**
     * Код ошибки, если нужно будет завязываться фронту на это
     */
    private String code;
    /**
     * Текст ошибки
     */
    private String text;
}
