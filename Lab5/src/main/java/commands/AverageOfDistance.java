package commands;

import console.Console;
import manager.CollectionManager;

/**
 * Класс, представляющий консольную команду average_of_distance
 * @author Ivan Kirillov
 */

public final class AverageOfDistance extends Command {
    private final CollectionManager collectionManager;
    private final Console console;
    /**
     * Конструктор класса команды average_of_distance
     */

    public AverageOfDistance(CollectionManager collectionManager, Console console) {
        super("average_of_distance", "Вывести среднее значение поля distance для всех элементов коллекции");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    /**
     * Выполняет команду
     * @return успешность выполнения команды
     */

    @Override
    public boolean execute(String argument) {
        var routes = collectionManager.getRoutes();
        Double averageDistance = collectionManager.averageDistance(routes);
        console.println("Среднее расстояние - " + averageDistance);
        return true;
    }
}
