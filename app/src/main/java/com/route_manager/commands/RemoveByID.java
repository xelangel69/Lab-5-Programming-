package com.route_manager.commands;

import com.route_manager.console.Console;
import com.route_manager.manager.CollectionManager;

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
        super("remove_by_id {ID}", "Удалить маршрут из коллекции по его ID");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new IllegalArgumentException("Введите ID!");

            long id = Long.parseLong(argument);

            var route = collectionManager.findById(id);
            if (route == null) {
                console.printErr("нет объекта с таким ID");
                return false;
            }

            collectionManager.removeElement(route);

            console.printSuccess("Маршрут с ID " + id + " удалён!");
            return true;

        } catch (NumberFormatException e) {
            console.printErr("ID должен быть числом!");
        } catch (Exception e) {
            console.printErr(e.getMessage());
        }
        return false;
    }
}
