package com.route_manager.commands;

/**
 * Класс, представляющий консольную команду exit
 * @author Ivan Kirillov
 */
public final class Exit extends Command {

    /**
     * Конструктор класса команда exit
     */
    public Exit() {
        super("exit", "Завершить программу (без сохранения в файл)");
    }

    @Override
    public boolean execute(String argument) {
        System.exit(0);
        return true;
    }
}
