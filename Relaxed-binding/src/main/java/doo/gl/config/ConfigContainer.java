package doo.gl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * This is an injectable config properties class that contains the 3 properties
 * that have been declared using different types of binding.
 */
@ConfigurationProperties(prefix = "doo.gl")
@Component
public class ConfigContainer {

    private String propertyInCamelCase;
    private String propertyUsingDashes;
    private String propertyInUpperCase;

    public String getPropertyInCamelCase() {
        return propertyInCamelCase;
    }

    public void setPropertyInCamelCase(String propertyInCamelCase) {
        this.propertyInCamelCase = propertyInCamelCase;
    }

    public String getPropertyUsingDashes() {
        return propertyUsingDashes;
    }

    public void setPropertyUsingDashes(String propertyUsingDashes) {
        this.propertyUsingDashes = propertyUsingDashes;
    }

    public String getPropertyInUpperCase() {
        return propertyInUpperCase;
    }

    public void setPropertyInUpperCase(String propertyInUpperCase) {
        this.propertyInUpperCase = propertyInUpperCase;
    }
}
