package exceptions;

public class FileIsEmptyException extends RuntimeException {
    public FileIsEmptyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Файл пустой!";
    }
}
