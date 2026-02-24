package model.asker;

import console.Console;
import exceptions.InvalidScriptInputException;
import model.Coordinates;
import util.Interrogator;

public final class CoordinatesAsker extends Asker<Coordinates> {
    private final Console console;

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
        var coordinates = new Coordinates(askX(), askY());
        return coordinates;
    }
}
