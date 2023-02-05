package com.example.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Ошибка которую будем кидать сами с нашего бека
 */
@Getter
@AllArgsConstructor
public class BackendException extends RuntimeException {
    private CabinetError error;
}
