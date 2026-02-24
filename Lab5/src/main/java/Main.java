import commands.*;
import console.Console;
import manager.AppManager;
import manager.CollectionManager;
import manager.CommandManager;
import manager.FileManager;
import model.Route;
import util.Interrogator;

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

        String fileName = args[0];

        Scanner scanner = new Scanner(System.in);
        Interrogator.setUserScanner(scanner);

        FileManager fileManager = new FileManager(fileName, console);
        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager(new HashMap<>(), console);

        Collection<Route> loadedCollection = fileManager.readCollection();
        collectionManager.setRoutes(loadedCollection);

        Route.updateIdCounter(loadedCollection);

        commandManager.registerCommand(new Help(commandManager, console));
        commandManager.registerCommand(new Info(collectionManager, console));
        commandManager.registerCommand(new Show(collectionManager));
        commandManager.registerCommand(new AddElement(collectionManager, console));
        commandManager.registerCommand(new UpdateByID(collectionManager, console));
        commandManager.registerCommand(new RemoveByID(collectionManager, console));
        commandManager.registerCommand(new Clear(collectionManager));
        commandManager.registerCommand(new Save(collectionManager, fileManager, console));
        commandManager.registerCommand(new ExecuteScript());
        commandManager.registerCommand(new Exit());
        commandManager.registerCommand(new AddIfMax(collectionManager, console));
        commandManager.registerCommand(new RemoveLower());
        commandManager.registerCommand(new History(commandManager, console));
        commandManager.registerCommand(new AverageOfDistance(collectionManager, console));
        commandManager.registerCommand(new FilterContainsName(collectionManager, console));
        commandManager.registerCommand(new PrintDescending());

        AppManager appManager = new AppManager(console, commandManager);
        appManager.run();
    }
}