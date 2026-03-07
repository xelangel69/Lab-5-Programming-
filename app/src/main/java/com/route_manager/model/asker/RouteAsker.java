package com.route_manager.model.asker;

import com.route_manager.exceptions.InvalidScriptInputException;
import com.route_manager.exceptions.FileIsEmptyException;
import com.route_manager.model.Coordinates;
import com.route_manager.model.Location;
import com.route_manager.model.Route;
import com.route_manager.console.Console;
import com.route_manager.util.Interrogator;

/**
 * Класс, запрашивающий у пользователя данные для создания нового маршрута
 * @author Ivan Kirillov
 */
public final class RouteAsker extends Asker<Route> {
    private final Console console;

    /**
     * Конструктор класса
     */
    public RouteAsker(Console console) {
        this.console = console;
    }

    @Override
    public Route builder(){
        return new Route(askName(),
                askCoordinates(),
                askFrom(),
                askTo(),
                askDistance());
    }

    /**
     * Запрашивает у пользователя название маршрута
     * @return название маршрута
     */
    public String askName(){
        var fileMode = Interrogator.fileMode();
        while(true){
            try {
                if ((!Interrogator.fileMode())) console.print("Введите название маршрута: ");

                String name = Interrogator.getUserScanner().nextLine();

                if (name.equals("")) throw new FileIsEmptyException("Имя не может быть пустым!");

                if (fileMode) console.println(name);
                return name;
            } catch (Exception e) {
                if (fileMode) throw new InvalidScriptInputException("Ошибка в скрипте: " + e.getMessage());
                console.printErr("Ошибка ввода: " + e.getMessage());
            }
        }
    }

    /**
     * Запрашивает у пользователя координаты
     * @return координаты (X, Y)
     */
    public Coordinates askCoordinates() {
        var coordinatesAsker = new CoordinatesAsker(console);
        return coordinatesAsker.builder();
    }

    /**
     * Запрашивает у пользователя место отправления
     * @return координаты (X, Y, Z)
     */
    public Location askFrom() {
        var locationAsker = new LocationFromAsker(console);
        return locationAsker.builder();
    }

    /**
     * Запрашивает у пользователя место прибытия
     * @return координаты (X, Y, Z)
     */
    public Location askTo() {
        var locationAsker = new LocationToAsker(console);
        return locationAsker.builder();
    }

    /**
     * Запрашивает у пользователя длину маршрута
     * @return дистанция маршрута
     */
    public Float askDistance() {
        var fileMode = Interrogator.fileMode();
        while(true){
            try {
                if ((!Interrogator.fileMode())) console.print("Введите дистанцию (> 1): ");

                var strDistance = Interrogator.getUserScanner().nextLine().trim();

                if (strDistance.isEmpty()) {
                    return null;
                } else {
                    float distance = Float.parseFloat(strDistance);

                    if (distance <= 1) throw new IllegalArgumentException("Число должно быть больше 1");

                    if (fileMode) console.println(distance);
                    return distance;
                }
            } catch (Exception e) {
                if (fileMode) throw new InvalidScriptInputException("Ошибка в скрипте: " + e.getMessage());
                console.printErr("Ошибка ввода: " + e.getMessage());
            }
        }
    }
}
