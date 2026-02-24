package commands;

/**
 * Класс, представляющий консольную команду remove_lower {element}
 * @author Ivan Kirillov
 */

public final class RemoveLower extends Command {

    /**
     * Конструктор класса команды remove_lower
     */

    public RemoveLower() {
        super("remove_lower", "Удалить из коллекции все элементы, меньшие, чем заданный");
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
