package doo.gl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * This class contains 2 collections of values that have been mapped from a .yml file.
 *
 * There is a list of values and a map of name -> integer
 */
@Component
@ConfigurationProperties(prefix = "doo.gl.collection")
public class ConfigCollectionContainer {

    private List<String> listProperties;

    private Map<String, Integer> mappedProperties;

    public List<String> getListProperties() {
        return listProperties;
    }

    public void setListProperties(List<String> listProperties) {
        this.listProperties = listProperties;
    }

    public Map<String, Integer> getMappedProperties() {
        return mappedProperties;
    }

    public void setMappedProperties(Map<String, Integer> mappedProperties) {
        this.mappedProperties = mappedProperties;
    }
}
