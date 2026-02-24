package commands;

/**
 * Класс, представляющий консольную команду execute_script {file_name}
 * @author Ivan Kirillov
 */

public final class ExecuteScript extends Command {

    /**
     * Конструктор класса команды execute_script
     */

    public ExecuteScript() {
        super("execute_script", "Считать и исполнить скрипт из указанного файла");
    }

    /**
     * Выполняет команду
     * @return успешность выполнения команды
     */

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
