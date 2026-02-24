package commands;

import console.Console;
import exceptions.HistoryIsEmptyException;
import manager.CommandManager;

/**
 * Класс, представляющий консольную команду history
 * @author Ivan Kirillov
 */

public final class History extends Command {
    private final CommandManager commandManager;
    private final Console console;

    /**
     * Конструктор класса команды history
     */

    public History(CommandManager commandManager, Console console) {
        super("history", "Вывести последние 7 команд (без их аргументов)");
        this.commandManager = commandManager;
        this.console = console;
    }

    /**
     * Выполняет команду
     * @return успешность выполнения команды
     */

    @Override
    public boolean execute(String argument) {
        var history = commandManager.getHistory();
        if (history.isEmpty()) throw new HistoryIsEmptyException(history.toString());
        else {
            console.println("Последние команды:");
            history.forEach(System.out::println);
        }
        return true;
    }
}
