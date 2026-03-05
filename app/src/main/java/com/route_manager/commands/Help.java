package com.route_manager.commands;

import com.route_manager.console.Console;
import com.route_manager.manager.CommandManager;

/**
 * Класс, представляющий консольную команду help
 * @author Ivan Kirillov
 */
public final class Help extends Command {
    private final CommandManager commandManager;
    private final Console console;

    /**
     * Конструктор класса команды help
     */
    public Help(CommandManager commandManager, Console console) {
        super("help", "Вывести справку по доступным командам");
        this.commandManager = commandManager;
        this.console = console;
    }

    @Override
    public boolean execute(String argument) {
        commandManager.getCommands().values().forEach(command -> {
            console.printTable(command.getName(), command.getDescription());
        });
        return true;
    }
}
