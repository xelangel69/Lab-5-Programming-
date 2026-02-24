package commands;

import console.Console;
import manager.CollectionManager;
import manager.FileManager;

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

    /**
     * Выполняет команду
     * @return успешность выполнения команды
     */

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
