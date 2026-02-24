package commands;

/**
 * Класс, представляющий консольную команду print_descending
 * @author Ivan Kirillov
 */

public final class PrintDescending extends Command {

    /**
     * Конструктор класса команды print_descending
     */

    public PrintDescending() {
        super("print_descending", "Вывести элементы коллекции в порядке убывания");
    }

    /**
     * Выполняет команду
     * @return успешность выполнения команды
     */

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
