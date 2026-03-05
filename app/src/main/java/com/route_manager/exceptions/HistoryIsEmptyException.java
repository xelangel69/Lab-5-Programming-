package com.route_manager.exceptions;

/**
 * Исключение, выбрасываемое при пустой истории команд
 * @author Ivan Kirillov
 */
public class HistoryIsEmptyException extends RuntimeException {
    public HistoryIsEmptyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
      return "история команд пуста!";
    }
}
