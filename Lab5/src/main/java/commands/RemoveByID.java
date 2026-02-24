package commands;

import console.Console;
import manager.CollectionManager;
import model.asker.RouteAsker;

/**
 * Класс, представляющий консольную команду remove_by_id {id}
 * @author Ivan Kirillov
 */

public final class RemoveByID extends Command {
    private final CollectionManager collectionManager;
    private final Console console;

    /**
     * Конструктор класса команды remove_by_id
     */

    public RemoveByID(CollectionManager collectionManager, Console console) {
        super("remove_by_id", "Удалить элемент из коллекции по его id");
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

            collectionManager.removeElement(route);

            console.println("Маршрут " + id + " удалён!");
            return true;

        } catch (NumberFormatException e) {
            console.printErr("ID должен быть числом!");
        } catch (Exception e) {
            console.printErr(e.getMessage());
        }
        return false;
    }
}
