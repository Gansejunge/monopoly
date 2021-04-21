package monopoly.field;

import java.util.ArrayList;
import java.util.List;

public class PropertyGroup {
    private String name;
    private String color;
    private List<Property> properties;

    public PropertyGroup(String name, String color){
        this.name = name;
        this.color = color;
        this.properties = new ArrayList<>();
    }

    public void addProperty(Property property){
        properties.add(property);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<Property> getProperties() {
        return properties;
    }
}
