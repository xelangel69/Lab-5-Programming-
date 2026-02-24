package manager;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import console.Console;
import model.Route;
import util.CollectionWrapper;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;

public final class FileManager {
    private final XmlMapper mapper;
    private final String fileName;
    private final Console console;

    public FileManager(String fileName, Console console) {
        this.fileName = fileName;
        this.mapper = new XmlMapper();
        this.console = console;

        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * Записывает коллекцию в файл
     */
    public void saveCollection(Collection<Route> collection) {
        try (FileWriter writer = new FileWriter(fileName)) {
            mapper.writeValue(writer, collection);
            console.println("Коллекция успешно сохранена в файл!");
        } catch (IOException e) {
            console.printErr(e.getMessage());
        }
    }

    /**
     * Считывает коллекцию из файла
     */
    public void writeCollection(Collection<Route> collection) {
        try (FileWriter writer = new FileWriter(fileName)) {
            CollectionWrapper wrapper = new CollectionWrapper(new HashSet<>(collection));

            mapper.writeValue(writer, wrapper);
            console.println("Коллекция успешно сохранена!");
        } catch (IOException e) {
            console.printErr(e.getMessage());
        }
    }

    public Collection<Route> readCollection() {
        if (fileName == null || fileName.isEmpty()) return new HashSet<>();

        File file = new File(fileName);
        if (!file.exists()) return new HashSet<>();

        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader reader = new InputStreamReader(fis)) {

            CollectionWrapper wrapper = mapper.readValue(reader, CollectionWrapper.class);
            return wrapper.getRoutes();
        } catch (IOException e) {
            console.printErr("Ошибка чтения: " + e.getMessage());
            return new HashSet<>();
        }
    }
}