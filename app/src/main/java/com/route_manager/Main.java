package com.route_manager;

import com.route_manager.commands.*;
import com.route_manager.console.Console;
import com.route_manager.exceptions.FileIsEmptyException;
import com.route_manager.exceptions.NoArgsException;
import com.route_manager.manager.*;
import com.route_manager.model.Route;
import com.route_manager.util.Interrogator;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();

        try {
            if (args.length == 0) throw new  NoArgsException("Введите имя загружаемого файла как аргумент командной строки");

            String fileName = args[0];
            File file = new File(fileName);

            if (file.length() == 0) throw new FileIsEmptyException("Файл пустой!");

            console.printSuccess("УПРАВЛЕНИЕ МАРШРУТАМИ");
            console.printByProgram("Добро пожаловать в программу для управления маршрутами!\nДля того, чтобы узнать список доступных команд введите 'help'.");

            Scanner scanner = new Scanner(System.in);
            Interrogator.setUserScanner(scanner);

            FileManager fileManager = new FileManager(fileName, console);
            CollectionManager collectionManager = new CollectionManager();
            CommandManager commandManager = new CommandManager(new HashMap<>(), console);

            Collection<Route> loadedCollection = fileManager.readCollection();
            collectionManager.setRoutes(loadedCollection);

            Route.updateIdCounter(loadedCollection);

            commandManager.registerCommand("help", new Help(commandManager, console));
            commandManager.registerCommand("info", new Info(collectionManager, console));
            commandManager.registerCommand("show", new Show(collectionManager, console));
            commandManager.registerCommand("add", new AddElement(collectionManager, console));
            commandManager.registerCommand("update", new UpdateByID(collectionManager, console));
            commandManager.registerCommand("remove_by_id", new RemoveByID(collectionManager, console));
            commandManager.registerCommand("clear", new Clear(collectionManager, console));
            commandManager.registerCommand("save", new Save(collectionManager, fileManager, console));
            commandManager.registerCommand("execute_script", new ExecuteScript(commandManager, console));
            commandManager.registerCommand("exit", new Exit());
            commandManager.registerCommand("add_if_max", new AddIfMax(collectionManager, console));
            commandManager.registerCommand("remove_lower", new RemoveLower(collectionManager, console));
            commandManager.registerCommand("history", new History(commandManager, console));
            commandManager.registerCommand("average_of_distance", new AverageOfDistance(collectionManager, console));
            commandManager.registerCommand("filter_contains_name", new FilterContainsName(collectionManager, console));
            commandManager.registerCommand("print_descending", new PrintDescending(collectionManager, console));

            AppManager appManager = new AppManager(console, commandManager);
            appManager.run();
        } catch (FileIsEmptyException e) {
            console.printErr(e.getMessage());
            System.exit(0);
        } catch (NoArgsException e) {
            console.printErr(e.getMessage());
            System.exit(1);
        } catch (Error e) {
            console.printErr(e.getClass().getName());
            System.exit(1);
        }
    }
}