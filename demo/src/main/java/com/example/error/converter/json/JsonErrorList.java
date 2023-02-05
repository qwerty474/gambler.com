package com.example.error.converter.json;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * Класс представляет сущность из json файла
 */
@Getter
public class JsonErrorList implements Serializable {

    /**
     * Список ошибок из json файла
     */
    private List<JsonError> errors;

    /**
     * Отдельная ошибка
     */
    @Getter
    static class JsonError implements Serializable {
        /**
         * Код нашей BackendException
         */
        private String code;
        /**
         * Код который пойдет на фронт
         */
        private String mapCode;
        /**
         * Текст ошибки
         */
        private String text;
    }
}
