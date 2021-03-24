package monopoly.field;

public class PropertyGroup {
    private String name;
    private String color;
    private Property [] properties;

    public PropertyGroup(String name, String color){
        this.name = name;
        this.color = color;
        //todo;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Property[] getProperties() {
        return properties;
    }
}
