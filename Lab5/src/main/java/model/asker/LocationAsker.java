package model.asker;

import console.Console;
import exceptions.InvalidScriptInputException;
import model.Location;
import util.Interrogator;

public final class LocationAsker extends Asker<Location> {
    private final Console console;

    public LocationAsker(Console console) {
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
        console.println("Ввод точки");
        var location = new Location(askX(), askY(), askZ());
        return location;
    }
}
