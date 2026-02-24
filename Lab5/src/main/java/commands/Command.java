package commands;

import manager.CommandManager;

/**
 * Абстрактный класс, представляющий класс предок для всех консольных команд
 * @author Ivan Kirillov
 */

public abstract class Command {
    private final String name;
    private final String description;

    /**
     * Конструктор класса команд
     * @param name название команды
     * @param description описание команды
     */

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract boolean execute(String argument);

    /**
     * Возвращает имя команды
     * @return сигнатура команды
     */

    public String getName() {
        return name;
    }

    /**
     * Возвращает описание команды
     * @return описание команды
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Command{name='" + name + '\'' + ", description='" + description + '\'' + '}';
    }
}