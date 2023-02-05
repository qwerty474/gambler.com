package com.gambler.error.converter;

import com.gambler.error.exception.BackendException;
import com.gambler.error.model.ResponseException;
import org.springframework.http.ResponseEntity;

/**
 * конвертирует из BackendException в ответ фронту
 */
public interface ResponseExceptionConverter {
    public ResponseEntity<ResponseException> convert(BackendException exception);
}
