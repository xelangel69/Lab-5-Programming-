package com.route_manager.model.asker;

import com.route_manager.console.Console;
import com.route_manager.exceptions.InvalidScriptInputException;
import com.route_manager.model.Location;
import com.route_manager.util.Interrogator;

/**
 * Класс, запрашивающий у пользователя данные для создания точки отправления
 * @author Ivan Kirillov
 */
public final class LocationFromAsker extends Asker<Location> {
    private final Console console;

    /**
     * Конструктор класса
     */
    public LocationFromAsker(Console console) {
        this.console = console;
    }

    /**
     * Запрашивает у пользователя координату X
     * @return координата X
     */
    public Long askX(){
        var fileMode = Interrogator.fileMode();
        while (true) {
            try {
                console.print("Введите X: ");

                var strX = Interrogator.getUserScanner().nextLine();
                long x = Long.parseLong(strX);

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
                console.print("Введите Y: ");

                var strY = Interrogator.getUserScanner().nextLine();
                int y = Integer.parseInt(strY);

                if (fileMode) console.println(y);
                return y;
            } catch (Exception e) {
                if (fileMode) throw new InvalidScriptInputException("Ошибка в скрипте: " + e.getMessage());
                console.printErr("Ошибка ввода: " + e.getMessage());
            }
        }
    }

    /**
     * Запрашивает у пользователя координату Z
     * @return координата Z
     */
    public Float askZ(){
        var fileMode = Interrogator.fileMode();
        while (true) {
            try {
                console.print("Введите Z: ");

                var strZ = Interrogator.getUserScanner().nextLine();
                float z = Float.parseFloat(strZ);

                if (fileMode) console.println(z);
                return z;
            } catch (Exception e) {
                if (fileMode) throw new InvalidScriptInputException("Ошибка в скрипте: " + e.getMessage());
                console.printErr(e.getMessage());
            }
        }
    }

    @Override
    public Location builder() {
        console.println("Ввод координат точки отправления");
        return new Location(askX(), askY(), askZ());
    }
}
