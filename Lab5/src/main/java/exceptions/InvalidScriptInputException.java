package exceptions;

public class InvalidScriptInputException extends RuntimeException {
    public InvalidScriptInputException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "история команд пуста!";
    }
}
