package commands;

import manager.CollectionManager;

/**
 * Класс, представляющий консольную команду show
 * @author Ivan Kirillov
 */

public final class Show extends Command {
    private final CollectionManager collectionManager;
    /**
     * Конструктор класса команды show
     */

    public Show(CollectionManager collectionManager) {
        super("show", "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return успешность выполнения команды
     */

    @Override
    public boolean execute(String argument) {
        System.out.println(collectionManager);
        return true;
    }
}
