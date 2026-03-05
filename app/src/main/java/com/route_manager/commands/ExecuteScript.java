package com.route_manager.commands;

import com.route_manager.console.Console;
import com.route_manager.exceptions.RecursionInScriptException;
import com.route_manager.manager.CollectionManager;
import com.route_manager.manager.FileManager;

/**
 * Класс, представляющий консольную команду execute_script {file_name}
 * @author Ivan Kirillov
 */
public final class ExecuteScript extends Command {
    private final CollectionManager collectionManager;
    private final FileManager fileManager;
    private final Console console;

    /**
     * Конструктор класса команды execute_script
     */
    public ExecuteScript(CollectionManager collectionManager, FileManager fileManager, Console console) {
        super("execute_script {файл}", "Считать и исполнить скрипт из указанного файла");
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
        this.console = console;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) console.printErr("Введите имя скрипта!");

            String fileName = argument;

            if (collectionManager.ifRecursion(fileName)) {
                throw new RecursionInScriptException("<UNK> <UNK> <UNK>!");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
