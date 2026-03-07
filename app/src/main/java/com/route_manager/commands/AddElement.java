package com.route_manager.commands;

import com.route_manager.console.Console;
import com.route_manager.manager.CollectionManager;
import com.route_manager.model.Route;
import com.route_manager.model.asker.RouteAsker;

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
        super("add", "Создать новый маршрут и добавить его в коллекцию");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public boolean execute(String argument) {
        console.printByProgram("СОЗДАНИЕ ОБЪЕКТА");

        Route route = new RouteAsker(console).builder();
        collectionManager.inputElement(route);

        console.printSuccess("Маршрут создан!");
        return true;

    }
}
