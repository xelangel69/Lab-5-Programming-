package commands;

import console.Console;
import manager.CollectionManager;

/**
 * Класс, представляющий консольную команду filter_contains_name {name}
 * @author Ivan Kirillov
 */

public final class FilterContainsName extends Command {
    private final CollectionManager collectionManager;
    private final Console console;

    /**
     * Конструктор класса команды filter_contains_name
     */

    public FilterContainsName(CollectionManager collectionManager, Console console) {
        super("filter_contains_name", "Вывести элементы, значение поля name которых содержит заданную подстроку");
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
            if (argument.isEmpty()) throw new IllegalArgumentException("Нужно ввести подстроку!");

            var route = collectionManager.findByName(argument);
            if (route == null) {
                console.printErr("Нет маршрута с такой подстрокой в названии!");
                return false;
            }

            console.println("Маршрут найден - " + route);
            return true;
        } catch (Exception e) {
            console.printErr(e.getMessage());
        }
        return false;
    }
}
