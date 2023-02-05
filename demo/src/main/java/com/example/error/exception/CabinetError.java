package com.example.error.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Перечисление наших внутренних ошибок
 */
@Getter
public enum CabinetError {

    UNKNOWN("unknown", ExceptionType.LK),
    NOT_FOUND("not.found", ExceptionType.LOGIC, HttpStatus.NOT_FOUND);

    /**
     * Наш внутренний код ошики, на фронт идти не должно
     */
    private String code;

    /**
     * Тип ошибки
     */
    private ExceptionType type;

    /**
     * Статус ответа сервера
     */
    private HttpStatus httpStatus;

    CabinetError(String code, ExceptionType type, HttpStatus httpStatus) {
        this.code = code;
        this.type = type;
        this.httpStatus = httpStatus;
    }

    CabinetError(String code, ExceptionType type) {
        this(code, type, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
