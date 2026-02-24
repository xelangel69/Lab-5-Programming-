package manager;

import console.Console;
import java.util.Scanner;

import exceptions.FailedCommandExecutionException;
import util.Interrogator;

public final class AppManager {
    private final Console console;
    private final CommandManager commandManager;

    public AppManager(Console console, CommandManager commandManager) {
        this.console = console;
        this.commandManager = commandManager;
    }

    public void run() {
        Scanner scanner = Interrogator.getUserScanner();

        while (true) {
            if (!Interrogator.fileMode()) {
                console.PC();
            }

            if (!scanner.hasNext()) {
                break;
            }

            String userCommand = scanner.nextLine().trim();

            if (userCommand.isEmpty()) {
                console.PC();
                continue;
            }

            try {
                commandManager.executeCommand(userCommand);
            } catch (FailedCommandExecutionException e) {
                console.printErr("Ошибка выполнения команды:" + e.getMessage());
            }
        }
    }
}