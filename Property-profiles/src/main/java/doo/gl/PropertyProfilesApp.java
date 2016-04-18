package doo.gl;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Starts a spring boot app on a port that is defined by the spring profile which is specified at runtime.
 *
 * If no profile is specified, the app runs with a default profile.
 */
@SpringBootApplication
@RestController
public class PropertyProfilesApp {

    private static final JsonNodeFactory JSON_FACTORY = JsonNodeFactory.instance;

    @Autowired
    private Environment environment;

    @RequestMapping("/")
    public ObjectNode getProfiles() {
        ObjectNode result = JSON_FACTORY.objectNode();
        ArrayNode arrayNode = result.putArray("activeSpringProfiles");
        Arrays.asList(environment.getActiveProfiles()).forEach(arrayNode::add);
        return result;
    }

    public static void main(String[] args) {
        String[] arguments;
//        arguments = new String[] {"--spring.profiles.active=dev"}; // applies dev profile
        arguments = new String[] {"--spring.profiles.active=dev,prod,test"}; // applies dev profile, then prod profile, then test profile so server port is the one defined by test
        SpringApplication.run(PropertyProfilesApp.class, arguments);
    }

}
