package commands;

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

    /**
     * Выполняет команду
     * @return успешность выполнения команды
     */

    @Override
    public boolean execute(String argument) {
        System.exit(0);
        return true;
    }
}
