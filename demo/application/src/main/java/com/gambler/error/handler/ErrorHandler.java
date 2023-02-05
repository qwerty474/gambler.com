package com.gambler.error.handler;

import com.gambler.error.converter.ResponseExceptionConverter;
import com.gambler.error.exception.BackendException;
import com.gambler.error.model.ResponseException;
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
