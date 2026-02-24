package console;

/**
 * Класс реализующий консольный ввод/вывод
 * @author Ivan Kirillov
 */

public final class Console implements ConsoleFunctions {
    private static final String PC = "$ ";
    @Override
    public void print(Object obj) {
        System.out.print(obj);
        System.out.flush();
    }

    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }

    @Override
    public void printTable(Object ob1, Object ob2) {
        System.out.printf("%-25s%-1s%n", ob1, ob2);
    }

    @Override
    public void printErr(Object obj) {
        System.out.println(TextColors.RED + "" + obj + TextColors.RESET);
    }

    @Override
    public void PC() {
        print(PC);
    }
}
