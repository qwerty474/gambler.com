package com.gambler.error.exception;

/**
 * Типы ошибок
 */
public enum ExceptionType {
    /**
     * Ошибка по нашей вине
     */
    LK,
    /**
     * Ошибка во внешней системе
     */
    EIS,
    /**
     * Логическая ошибка фронтов
     */
    LOGIC;
}
