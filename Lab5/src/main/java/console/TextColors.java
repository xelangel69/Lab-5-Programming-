package console;

public enum TextColors {
    RESET ("\u001B[0m"),
    RED ("\u001B[31m"),
    GREEN ("\u001B[32m"),
    WHITE ("\u001B[37m");

    private final String code;

    TextColors(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}

