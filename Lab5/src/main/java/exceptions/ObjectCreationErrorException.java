package exceptions;

/**
 * Исключение, выбрасываемое при ошибке создания объекта
 * @author Ivan Kirillov
 */

public class ObjectCreationErrorException extends RuntimeException {
    public ObjectCreationErrorException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "произошла ошибка при создании объекта!";
    }
}
