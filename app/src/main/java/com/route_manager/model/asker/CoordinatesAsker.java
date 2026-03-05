package com.route_manager.model.asker;

import com.route_manager.console.Console;
import com.route_manager.exceptions.InvalidScriptInputException;
import com.route_manager.model.Coordinates;
import com.route_manager.util.Interrogator;

/**
 * Класс, запрашивающий у пользователя данные для создания нового маршрута
 * @author Ivan Kirillov
 */
public final class CoordinatesAsker extends Asker<Coordinates> {
    private final Console console;

    /**
     * Конструктор класса
     */
    public CoordinatesAsker(Console console) {
        this.console = console;
    }

    /**
     * Запрашивает у пользователя координату X
     * @return координата X
     */
    public Double askX() {
        var fileMode = Interrogator.fileMode();
        while (true) {
            try {
                console.print("Введите X: ");

                var strX = Interrogator.getUserScanner().nextLine();
                double x = Double.parseDouble(strX);

                if (fileMode) console.println(x);
                return x;
            } catch (Exception e) {
                if (fileMode) throw new InvalidScriptInputException("Ошибка в скрипте: " + e.getMessage());
                console.printErr("Ошибка ввода: " + e.getMessage());
            }
        }
    }

    /**
     * Запрашивает у пользователя координату Y
     * @return координата Y
     */
    public Integer askY(){
        var fileMode = Interrogator.fileMode();
        while (true) {
            try {
                console.print("Введите Y (<= 71): ");

                var strY = Interrogator.getUserScanner().nextLine();
                int y = Integer.parseInt(strY);

                if (y > 71) throw new IllegalArgumentException("Y должен быть меньше 71");

                if (fileMode) console.println(y);
                return y;
            } catch (Exception e) {
                if (fileMode) throw new InvalidScriptInputException("Ошибка в скрипте: " + e.getMessage());
                console.printErr("Ошибка ввода: " + e.getMessage());
            }
        }
    }

    @Override
    public Coordinates builder() {
        console.println("Ввод координат");
        return new Coordinates(askX(), askY());
    }
}
