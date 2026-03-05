package com.route_manager.exceptions;

/**
 * Исключение,выбрасываемое, если файл пустой
 * @author Ivan Kirillov
 */
public class FileIsEmptyException extends RuntimeException {
    public FileIsEmptyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Файл пустой!";
    }
}
