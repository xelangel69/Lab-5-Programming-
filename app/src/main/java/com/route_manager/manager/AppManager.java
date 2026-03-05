package com.route_manager.manager;

import com.route_manager.console.Console;

import java.util.Scanner;

import com.route_manager.exceptions.FailedCommandExecutionException;
import com.route_manager.util.Interrogator;

/**
 * Мененджер приложения - управляет всем приложением
 * @author Ivan Kirillov
 */
public final class AppManager {
    private final Console console;
    private final CommandManager commandManager;

    /**
     * Конструктор мененджера приложения
     */
    public AppManager(Console console, CommandManager commandManager) {
        this.console = console;
        this.commandManager = commandManager;
    }

    /**
     * Запускает приложение
     */
    public void run() {
        Scanner scanner = Interrogator.getUserScanner();

        while (true) {
            if (!Interrogator.fileMode()) {
                console.PC();
            }

            if (!scanner.hasNextLine()) {
                break;
            }

            String userCommand = scanner.nextLine().trim();

            if (userCommand.isEmpty()) {
                continue;
            }

            try {
                commandManager.executeCommand(userCommand);
            } catch (FailedCommandExecutionException e) {
                console.printErr("Ошибка выполнения команды: " + e.getMessage());
            }
        }
    }
}