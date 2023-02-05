package com.example.error.converter;

import com.example.error.exception.BackendException;
import com.example.error.model.ResponseException;
import org.springframework.http.ResponseEntity;

/**
 * конвертирует из BackendException в ответ фронту
 */
public interface ResponseExceptionConverter {
    public ResponseEntity<ResponseException> convert(BackendException exception);
}
