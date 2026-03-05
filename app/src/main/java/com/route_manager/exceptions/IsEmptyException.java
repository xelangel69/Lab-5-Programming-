package com.route_manager.exceptions;

/**
 * Исключение, выбрасываемое если данные должны быть не пустыми
 * @author Ivan Kirillov
 */
public class IsEmptyException extends RuntimeException {
    public IsEmptyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
