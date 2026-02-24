package commands;

import console.Console;
import exceptions.ObjectCreationErrorException;
import manager.CollectionManager;
import model.Route;
import model.asker.RouteAsker;

/**
 * Класс, представляющий консольную команду add_if_max {element}
 * @author Ivan Kirillov
 */

public final class AddIfMax extends Command {
    private final CollectionManager collectionManager;
    private final Console console;

    /**
     * Конструктор класса команды add_if_max
     */

    public AddIfMax(CollectionManager collectionManager, Console console) {
        super("add_if_max", "Добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
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
            if (route.getDistance() > collectionManager.maxDistance()){
                collectionManager.inputElement(route);
                console.println("Маршрут успешно добавлен в коллекцию");
                return true;
            } else {
                console.println("Маршрут не был добавлен, т.к. расстояние меньше максимального");
                return false;
            }
        } catch (ObjectCreationErrorException e) {
            System.err.println("Ошибка при создании объекта: " + e.getMessage());
            return false;
        }
    }
}
