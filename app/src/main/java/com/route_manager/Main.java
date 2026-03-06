package com.route_manager;

import com.route_manager.commands.*;
import com.route_manager.console.Console;
import com.route_manager.manager.AppManager;
import com.route_manager.manager.CollectionManager;
import com.route_manager.manager.CommandManager;
import com.route_manager.manager.FileManager;
import com.route_manager.model.Route;
import com.route_manager.util.Interrogator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();

        if (args.length == 0) {
            console.println("Введите имя загружаемого файла как аргумент командной строки");
            System.exit(1);
        }

        console.printSuccess("УПРАВЛЕНИЕ МАРШРУТАМИ");
        console.printByProgram("Добро пожаловать в программу для управления маршрутами!\nДля того, чтобы узнать список доступных команд введите 'help'.");

        String fileName = args[0];

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
        commandManager.registerCommand("execute_script", new ExecuteScript(collectionManager, commandManager, fileManager, console));
        commandManager.registerCommand("exit", new Exit());
        commandManager.registerCommand("add_if_max", new AddIfMax(collectionManager, console));
        commandManager.registerCommand("remove_lower", new RemoveLower(collectionManager, console));
        commandManager.registerCommand("history", new History(commandManager, console));
        commandManager.registerCommand("average_of_distance", new AverageOfDistance(collectionManager, console));
        commandManager.registerCommand("filter_contains_name", new FilterContainsName(collectionManager, console));
        commandManager.registerCommand("print_descending", new PrintDescending(collectionManager, console));

        AppManager appManager = new AppManager(console, commandManager);
        appManager.run();
    }
}