package commands;

import manager.CollectionManager;

/**
 * Класс, представляющий консольную команду clear
 * @author Ivan Kirillov
 */

public final class Clear extends Command {
    private final CollectionManager collectionManager;

    /**
     * Конструктор класса команды clear
     */

    public Clear(CollectionManager collectionManager) {
        super("clear", "Очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return успешность выполнения команды
     */

    @Override
    public boolean execute(String argument) {
        collectionManager.clearCollection();
        return true;
    }
}
