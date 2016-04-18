package doo.gl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This contains a the mapping of .yml properties to a complex type.
 *
 * The properties have been mapped onto the ComplexProperties class and a list of these classes has been created.
 */
@Component
@ConfigurationProperties(prefix = "doo.gl.complex")
public class ComplexConfigContainer {

    private List<ComplexProperties> complexProperties;

    public List<ComplexProperties> getComplexProperties() {
        return complexProperties;
    }

    public void setComplexProperties(List<ComplexProperties> complexProperties) {
        this.complexProperties = complexProperties;
    }
}
