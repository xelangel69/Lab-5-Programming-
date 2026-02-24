package manager;

import commands.Command;
import console.Console;
import exceptions.UnknownCommandException;

import java.util.ArrayDeque;
import java.util.Map;

public final class CommandManager {
    private final Map<String, Command> commands;
    ArrayDeque<String> commandList = new ArrayDeque<String>(7);
    private final Console console;

    public CommandManager(Map<String, Command> commands, Console console) {
        this.commands = commands;
        this.console = console;
    }

    public void registerCommand(Command command) {
        commands.put(command.getName(), command);
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public ArrayDeque<String> getHistory(){
        return commandList;
    }

    public void executeCommand(String userInput) {
        String[] tokens = userInput.trim().split("\\s", 2);
        String commandName = tokens[0];
        String argument = (tokens.length > 1) ? tokens[1] : "";

        Command command = commands.get(commandName);

        try {
            if (command == null) {
                throw new UnknownCommandException(commandName);
            }

            command.execute(argument);
            commandList.addLast(commandName);

            if (commandList.size() > 7) {
                commandList.removeFirst();
            }
        } catch (UnknownCommandException e) {
            console.printErr("Неизвестная команда: " + commandName);
        }
    }

    @Override
    public String toString() {
        return commands.toString();
    }
}
