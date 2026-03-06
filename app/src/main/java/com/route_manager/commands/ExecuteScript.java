package com.route_manager.commands;

import com.route_manager.console.Console;
import com.route_manager.exceptions.RecursionInScriptException;
import com.route_manager.manager.CollectionManager;
import com.route_manager.manager.CommandManager;
import com.route_manager.manager.FileManager;
import com.route_manager.util.Interrogator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Класс, представляющий консольную команду execute_script {file_name}
 * @author Ivan Kirillov
 */
public final class ExecuteScript extends Command {
    private final CollectionManager collectionManager;
    private final CommandManager commandManager;
    private final FileManager fileManager;
    private final Console console;

    /**
     * Конструктор класса команды execute_script
     */
    public ExecuteScript(CollectionManager collectionManager, CommandManager commandManager, FileManager fileManager, Console console) {
        super("execute_script {файл}", "Считать и исполнить скрипт из указанного файла");
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
        this.fileManager = fileManager;
        this.console = console;
    }

    static HashSet<String> scriptStack = new HashSet<>();

    @Override
    public boolean execute(String argument) {

        if (argument.isEmpty()) console.printErr("Укажите имя скрипта!");

        File script = new File(argument);
        String scriptName = script.getName();

        if (scriptStack.contains(scriptName)) {
            throw new RecursionInScriptException("В скрипте обнаружена рекурсия!");
        }

        scriptStack.add(script.getName());

        try {
            try (Scanner preScanner = new Scanner(script)) {
                while (preScanner.hasNextLine()) {
                    String line = preScanner.nextLine().trim();
                    String[] tokens = line.split(" ");

                    if (tokens[0].equals("execute_script") && tokens.length > 1) {
                        String calledScript = new File(tokens[1]).getName();

                        if (calledScript.equals(scriptName) || scriptStack.contains(calledScript)) {
                            throw new RecursionInScriptException("В скрипте обнаружена рекурсия!");
                        }
                    }
                }
            } catch (RecursionInScriptException e) {
                console.printErr(e.getMessage());
                return false;
            }

            Scanner oldScanner = Interrogator.getUserScanner();
            Scanner scriptScanner = new Scanner(script);

            try {
                Interrogator.setUserScanner(scriptScanner);
                Interrogator.setFileMode();

                console.printByProgram("Выполнение скрипта...");

                while (scriptScanner.hasNextLine()) {
                    String line = scriptScanner.nextLine();
                    console.printByProgram("Выполнение команды '" + line.trim().split(" ")[0] + "'");
                    commandManager.executeCommand(line);
                    console.print("\n");
                }

                console.printSuccess("Скрипт успешно выполнен!");
                return true;
            } finally {
                Interrogator.setUserScanner(oldScanner);
                Interrogator.setUserMode();
                scriptStack.remove(script.getName());
            }
        } catch (FileNotFoundException e) {
            console.printErr("Файл не найден!");
            scriptStack.remove(scriptName);
        }
        return false;
    }
}
