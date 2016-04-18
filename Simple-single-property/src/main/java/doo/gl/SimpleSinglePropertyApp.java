package doo.gl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class uses spring boot to create a simple webserver.
 * It exposes an endpoint at http://localhost:8080/ that returns the value of the property named 'foo'
 *
 * The property named 'foo' is pulled into the app using a member variable to the class and the @Value annotation.
 * The annotation requires that the property be surrounded with ${  } because this is how spring references property names in it's environment.
 *
 */
@SpringBootApplication
@RestController
public class SimpleSinglePropertyApp {

    @Value("${foo}")
    private String foo;

    @RequestMapping("/")
    public String getFoo() {
        return foo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleSinglePropertyApp.class, args);
    }

}
