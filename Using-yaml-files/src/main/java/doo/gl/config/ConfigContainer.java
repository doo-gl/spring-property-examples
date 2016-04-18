package doo.gl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Contains a simple set of properties.
 *
 * They are simple mappings from property name -> simple value
 *
 */
@ConfigurationProperties(prefix = "doo.gl.simple")
@Component
public class ConfigContainer {

    private String someSimpleProperty;

    private String randomValue;

    private Integer randomInt;

    private String randomIntRange;

    public String getSomeSimpleProperty() {
        return someSimpleProperty;
    }

    public void setSomeSimpleProperty(String someSimpleProperty) {
        this.someSimpleProperty = someSimpleProperty;
    }

    public String getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(String randomValue) {
        this.randomValue = randomValue;
    }

    public Integer getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(Integer randomInt) {
        this.randomInt = randomInt;
    }

    public String getRandomIntRange() {
        return randomIntRange;
    }

    public void setRandomIntRange(String randomIntRange) {
        this.randomIntRange = randomIntRange;
    }
}
