package doo.gl;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

/**
 * Starts a webapp on endpoint http://localhost:8088/
 *
 * This returns the converted value of our ZonedDateTime property.
 */
@SpringBootApplication
@RestController
public class PropertyConverterApp {

    private static final JsonNodeFactory JSON_FACTORY = JsonNodeFactory.instance;

    // By default, you'll get the following error:

    // Caused by: java.lang.IllegalStateException:
    // Cannot convert value of type [java.lang.String] to required type [java.time.ZonedDateTime]:
    // no matching editors or conversion strategy found
    @Value("${doo.gl.theFarFuture}")
    private ZonedDateTime theFarFuture;

    @RequestMapping("/")
    public ObjectNode getProfiles() {
        ObjectNode result = JSON_FACTORY.objectNode();
        result.put("theFarFuture", theFarFuture.toString());
        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(PropertyConverterApp.class, args);
    }

}
