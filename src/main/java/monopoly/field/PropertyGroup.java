package monopoly.field;

public class PropertyGroup {
    private String name;
    private String color;
    private Property [] properties;

    public PropertyGroup(){
        this.name = "";
        this.color = "#f00";
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
