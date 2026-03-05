package com.route_manager.commands;

import com.route_manager.console.Console;
import com.route_manager.manager.CollectionManager;
import com.route_manager.manager.FileManager;

/**
 * Класс, представляющий консольную команду save
 * @author Ivan Kirillov
 */
public final class Save extends Command {
    private final CollectionManager collectionManager;
    private final FileManager fileManager;
    private final Console console;

    /**
     * Конструктор класса команды save
     */
    public Save(CollectionManager collectionManager, FileManager fileManager, Console console) {
        super("save", "Сохранить коллекцию в файл");
        this.fileManager = fileManager;
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public boolean execute(String argument) {
        var collectionToSave = collectionManager.getRoutes();
        try {
            fileManager.saveCollection(collectionToSave);
        } catch (Exception e) {
            console.printErr(e.getMessage());
        }
        return true;
    }
}
