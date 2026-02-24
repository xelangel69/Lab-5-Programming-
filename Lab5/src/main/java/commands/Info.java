package commands;

import console.Console;
import manager.CollectionManager;

/**
 * Класс, представляющий консольную команду info
 * @author Ivan Kirillov
 */

public final class Info extends Command {
    private final CollectionManager collectionManager;
    private final Console console;

    /**
     * Конструктор класса команды info
     * @param collectionManager мененджер коллекции
     */

    public Info(CollectionManager collectionManager, Console console) {
        super("info", "Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    /**
     * Выполняет команду
     * @return успешность выполнения команды
     */

    @Override
    public boolean execute(String argument) {
        console.println(collectionManager.getInfo());
        return true;
    }
}
