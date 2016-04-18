package doo.gl;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doo.gl.config.ComplexConfigContainer;
import doo.gl.config.ConfigCollectionContainer;
import doo.gl.config.ConfigContainer;

/**
 * Starts a spring boot app with endpoints:
 * http://localhost:8083/simple
 * http://localhost:8083/collections
 * http://localhost:8083/complex
 *
 * These endpoints return the contents of a .yml set of properties.
 */
@SpringBootApplication
@RestController
public class YamlFileApp {

    private static final JsonNodeFactory JSON_FACTORY = JsonNodeFactory.instance;

    @Autowired
    private ConfigContainer configContainer;

    @RequestMapping("/simple")
    public ObjectNode getConfig() {
        return JSON_FACTORY.objectNode()
            .put("SomeSimpleProperty", configContainer.getSomeSimpleProperty())
            .put("RandomValue", configContainer.getRandomValue())
            .put("RandomInt", configContainer.getRandomInt())
            .put("RandomIntRange", configContainer.getRandomIntRange())
            ;
    }


    @Autowired
    private ConfigCollectionContainer configCollectionContainer;

    @RequestMapping("/collections")
    public ObjectNode getConfigCollections() {
        ObjectNode result = JSON_FACTORY.objectNode();
        ArrayNode array = result.putArray("listProperties");
        configCollectionContainer.getListProperties().forEach(array::add);
        ObjectNode mappedProperties = result.putObject("mappedProperties");
        configCollectionContainer.getMappedProperties().forEach(mappedProperties::put);
        return result;
    }


    @Autowired
    private ComplexConfigContainer complexConfigContainer;

    @RequestMapping("/complex")
    public ObjectNode getConfigComplex() {
        ObjectNode result = JSON_FACTORY.objectNode();
        ArrayNode array = result.putArray("complexProperties");
        complexConfigContainer.getComplexProperties().forEach(complexProperties -> {
            ObjectNode container = JSON_FACTORY.objectNode()
                .put("id", complexProperties.getId())
                .put("name", complexProperties.getName());
            ArrayNode counts = container.putArray("counts");
            complexProperties.getCounts().forEach(counts::add);
            array.add(container);
        });
        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(YamlFileApp.class, args);
    }

}
