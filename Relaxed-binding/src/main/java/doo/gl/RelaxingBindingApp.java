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
 * Starts a spring boot app on endpoint http://localhost:8082/
 *
 * It returns the 3 properties that have been defined using different property bindings in a Json format.
 */
@SpringBootApplication
@RestController
public class RelaxingBindingApp {

    private static final JsonNodeFactory JSON_FACTORY = JsonNodeFactory.instance;

    @Autowired
    private ConfigContainer configContainer;

    @RequestMapping("/")
    public ObjectNode getConfig() {
        return JSON_FACTORY.objectNode()
            .put("PropertyInCamelCase", configContainer.getPropertyInCamelCase())
            .put("PropertyUsingDashes", configContainer.getPropertyUsingDashes())
            .put("PropertyInUpperCase", configContainer.getPropertyInUpperCase())
            ;
    }

    public static void main(String[] args) {
        SpringApplication.run(RelaxingBindingApp.class, args);
    }

}
