package util;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import model.Route;

import java.util.HashSet;
import java.util.Set;

@JacksonXmlRootElement(localName = "Routes")
public class CollectionWrapper {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Route")
    private Set<Route> routes;

    public CollectionWrapper() {
        this.routes = new HashSet<>();
    }

    public CollectionWrapper(Set<Route> routes) {
        this.routes = routes;
    }

    public Set<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }
}