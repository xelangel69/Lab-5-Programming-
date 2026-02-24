package commands;

import console.Console;
import exceptions.ObjectCreationErrorException;
import manager.CollectionManager;
import model.Route;
import model.asker.RouteAsker;

/**
 * Класс, представляющий консольную команду add
 * @author Ivan Kirillov
 */

public final class AddElement extends Command {
    private final CollectionManager collectionManager;
    private final Console console;
    /**
     * Конструктор класса команды add
     */

    public AddElement(CollectionManager collectionManager, Console console) {
        super("add", "Добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    /**
     * Выполняет команду
     * @return успешность выполнения команды
     */

    @Override
    public boolean execute(String argument) {
        try {
            Route route = new RouteAsker(console).builder();
            collectionManager.inputElement(route);
            return true;
        } catch (ObjectCreationErrorException e) {
            System.err.println("Ошибка при создании объекта: " + e.getMessage());
            return false;
        }
    }
}
