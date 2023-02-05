package com.example.error.handler;

import com.example.error.converter.ResponseExceptionConverter;
import com.example.error.exception.BackendException;
import com.example.error.model.ResponseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Класс для ловли ошибок на контроллерах
 */
@ControllerAdvice
@RequiredArgsConstructor
public class ErrorHandler {

    private final ResponseExceptionConverter responseExceptionConverter;

    /**
     * Отлавливает ошибки типа BackendException
     */
    @ExceptionHandler(BackendException.class)
    public ResponseEntity<ResponseException> handle(BackendException exception) {
        return responseExceptionConverter.convert(exception);
    }
}
