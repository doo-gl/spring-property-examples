package doo.gl;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doo.gl.config.ConfigContainer;

/**
 * Starts a spring boot app with a single endpoint at http://localhost:8082/
 *
 * We use the JsonNodeFactory to create a Json object to output back to the user.
 * JsonNodeFactory is included as part of the spring-boot-starter-web dependency.
 */
@SpringBootApplication
@RestController
public class ConfigPropertiesApp {

    private static final JsonNodeFactory JSON_FACTORY = JsonNodeFactory.instance;

    @Autowired
    private ConfigContainer configContainer;

    @RequestMapping("/")
    public ObjectNode getConfig() {
        return JSON_FACTORY.objectNode()
            .put("Foo", configContainer.getFoo())
            .put("Bar", configContainer.getBar())
            .put("Foobar", configContainer.getFoobar())
            ;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigPropertiesApp.class, args);
    }

}
