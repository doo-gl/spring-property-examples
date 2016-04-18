package doo.gl.config;

import java.util.List;

/**
 * This is a pojo that acts as a container for spring properties.
 */
public class ComplexProperties {

    private String id;

    private String name;

    private List<Integer> counts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getCounts() {
        return counts;
    }

    public void setCounts(List<Integer> counts) {
        this.counts = counts;
    }
}
