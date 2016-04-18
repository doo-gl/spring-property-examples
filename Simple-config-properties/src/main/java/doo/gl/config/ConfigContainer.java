package doo.gl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * This is the container for spring properties that begin with 'doo.gl'
 * So 'doo.gl.foo', 'doo.gl.bar' and 'doo.gl.foobar' will all be mapped to this class.
 *
 * The class requires getters and setters if the values are going to be set and used.
 *
 * It has been annotated with @Component to make the class an injectable / autowireable bean.
 *
 * In order for this class to be included in the application context for spring, it needs to be
 * in a directory descended from the directory that contains the root application. That is, the
 * class that has been annotated with @SpringBootApplication
 */
@ConfigurationProperties(prefix = "doo.gl")
@Component
public class ConfigContainer {

    private String foo;

    private String bar;

    private String foobar;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public String getFoobar() {
        return foobar;
    }

    public void setFoobar(String foobar) {
        this.foobar = foobar;
    }
}
