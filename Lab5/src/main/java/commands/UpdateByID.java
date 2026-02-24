package commands;

import console.Console;
import manager.CollectionManager;
import model.Route;
import model.asker.RouteAsker;

/**
 * Класс, представляющий консольную команду update {id} {element}
 * @author Ivan Kirillov
 */

public final class UpdateByID extends Command {
    private final CollectionManager collectionManager;
    private final Console console;

    /**
     * Конструктор класса команды update
     */

    public UpdateByID(CollectionManager collectionManager, Console console) {
        super("update", "Обновить значение элемента коллекции, id которого равен заданному");
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
            if (argument.isEmpty()) throw new IllegalArgumentException("нужен ID!");

            long id = Long.parseLong(argument);

            var route = collectionManager.findById(id);
            if (route == null) {
                console.printErr("нет объекта с таким ID");
                return false;
            }

            console.println("Введите новые данные для маршрута:");
            var newRoute = new RouteAsker(console).builder();

            updateRoute(route, newRoute);

            console.println("Маршрут обновлен!");
            return true;

        } catch (NumberFormatException e) {
            console.printErr("ID должен быть числом!");
        } catch (Exception e) {
            console.printErr(e.getMessage());
        }
        return false;
    }

    private void updateRoute(Route oldRoute, Route newRoute) {
        oldRoute.setName(newRoute.getName());
        oldRoute.setCoordinates(newRoute.getCoordinates());
        oldRoute.setFrom(newRoute.getFrom());
        oldRoute.setTo(newRoute.getTo());
        oldRoute.setDistance(newRoute.getDistance());
    }
}