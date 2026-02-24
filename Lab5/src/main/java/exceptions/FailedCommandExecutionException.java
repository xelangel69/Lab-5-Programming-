package exceptions;

public class FailedCommandExecutionException extends RuntimeException {
    public FailedCommandExecutionException(String message) {
        super(message);
    }
}
