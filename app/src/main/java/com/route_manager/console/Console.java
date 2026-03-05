package com.route_manager.console;

/**
 * Класс реализующий консольный ввод/вывод
 * @author Ivan Kirillov
 */
public final class Console implements ConsoleFunctions {
    private static final String PC = "$ ";

    /**
     * Вывод в консоль
     * @param obj объект для вывода
     */
    @Override
    public void print(Object obj) {
        System.out.print(obj);
        System.out.flush();
    }

    /**
     * Вывод в консоль с новой строки
     * @param obj объект для вывода
     */
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }

    /**
     * Вывод таблицы в консоль
     * @param obj1 первый объект (будет выведен слева)
     * @param obj2 второй объект (будет выведен справа)
     */
    @Override
    public void printTable(Object obj1, Object obj2) {
        System.out.printf("%-45s%-1s%n", TextColors.YELLOW + "" + obj1 + TextColors.RESET, obj2);
    }

    /**
     * Вывод ошибки в консоль
     * @param obj объект для вывода
     */
    @Override
    public void printErr(Object obj) {
        System.out.println(TextColors.RED + "" + obj + TextColors.RESET);
    }

    /**
     * Вывод в консоль в случае успешного выполнения команды
     * @param obj объект для вывода
     */
    @Override
    public void printSuccess(Object obj) {
        System.out.println(TextColors.GREEN + "" + obj + TextColors.RESET);
    }

    /**
     * Вывод информационных сообщений в консоль
     * @param obj объект для вывода
     */
    @Override
    public void printByProgram(Object obj) {
        System.out.println(TextColors.YELLOW + "" + obj + TextColors.RESET);
    }

    /**
     * Символ-приглашение к вводу
     */
    @Override
    public void PC() {
        print(PC);
    }
}
