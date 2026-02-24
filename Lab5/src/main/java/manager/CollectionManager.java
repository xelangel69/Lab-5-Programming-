package manager;

import model.Route;

import java.util.*;
import java.util.regex.Pattern;

public final class CollectionManager {
    private final java.time.ZonedDateTime initialTime;
    private final Collection<Route> routes = new HashSet<>();

    /**
     * Конструктор класса мененджера коллекции
     */

    public CollectionManager() {
        initialTime = java.time.ZonedDateTime.now();
    }

    public Route findById(long id) {
        return routes.stream()
                .filter(route -> route.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Route findByName(String name) {
        Pattern regex = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
        return routes.stream()
                .filter(route -> route.getName().contains(name))
                .findFirst()
                .orElse(null);
    }

    public Double averageDistance(Collection<Route> routes) {
        return routes.stream()
                .mapToDouble(Route::getDistance)
                .average()
                .orElse(0);
    }

    public Double maxDistance() {
        return routes.stream()
                .mapToDouble(Route::getDistance)
                .max()
                .orElse(0);
    }

    public void inputElement(Route r) {
        routes.add(r);
    }

    public void removeElement(Route r) {
        routes.remove(r);
    }

    public String getInfo() {
        return "Тип коллекции: " + routes.getClass().getSimpleName() + "\nВремя инициализации: " + initialTime + "\nРазмер: " +  routes.size();
    }

    public void setRoutes(Collection<Route> routes) {
        this.routes.addAll(routes);
    }

    public Collection<Route> getRoutes() {
        return routes;
    }

    public void clearCollection() {
        routes.clear();
    }

    @Override
    public String toString() {
        if (routes.isEmpty()) return "Коллекция пуста";

        return routes.stream()
                .sorted(Comparator.comparing(Route::getId))
                .map(Route::toString)
                .collect(java.util.stream.Collectors.joining("\n"));
    }
}
