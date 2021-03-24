package monopoly;

import monopoly.field.*;

import java.util.ArrayList;
import java.util.List;


public class Board {
    private List<Field> fields;
    private PropertyGroup propertyGroup;
    public Board(){
        fields = new ArrayList<>();
        initBoard();
        ;
    }

    public List<Field> getAllFields(){
        return fields;
    }

    public Field movePlayer(Player player, int step){
        int resultingPosition = (player.getPosition() + step) % fields.size();
        player.setPosition(resultingPosition);
        return fields.get(resultingPosition);
    }

    private void initBoard(){
        fields.add(new Go());
        propertyGroup = new PropertyGroup("brown","#A52A2A");
        fields.add(new Estate("Badstraße", propertyGroup, new int[]{9999}));
        fields.add(new ActionField()); //todo Gemeinschaftsfeld
        fields.add(new Estate("Turmstraße", propertyGroup, new int[]{9999}));
        fields.add(new ActionField()); //todo Einkommenssteuer
        fields.add(new Trainstation("Südbahnhof"));
        propertyGroup = new PropertyGroup("lightblue","#00FFFF");
        fields.add(new Estate("Chaussestrasse", propertyGroup, new int[]{9999}));
        fields.add(new ActionField()); //todo Ereigniskarte
        fields.add(new Estate("Elisenstraße", propertyGroup, new int[]{9999}));
        fields.add(new Estate("Poststraße", propertyGroup, new int[]{9999}));
        fields.add(new Prison());
        propertyGroup = new PropertyGroup("purple","#8904B1");
        fields.add(new Estate("Seestraße", propertyGroup, new int[]{9999}));
        fields.add(new PublicInfrastructure("Elektrizitätswerk"));
        fields.add(new Estate("Hafenstraße", propertyGroup, new int[]{9999}));
        fields.add(new Estate("Neue Straße", propertyGroup, new int[]{9999}));
        fields.add(new Trainstation("Westbahnhof"));
        propertyGroup = new PropertyGroup("orange","#FF8000");
        fields.add(new Estate("Münchener Straße", propertyGroup, new int[]{9999}));
        fields.add(new ActionField()); //todo Gemeinschaftsfeld
        fields.add(new Estate("Wiener Straße", propertyGroup, new int[]{9999}));
        fields.add(new Estate("Berliner Straße", propertyGroup, new int[]{9999}));
        fields.add(new ActionField()); //todo frei parken
        propertyGroup = new PropertyGroup("red","#DF0101");
        fields.add(new Estate("Theaterstraße", propertyGroup, new int[]{9999}));
        fields.add(new ActionField()); //todo Ereigniskarte
        fields.add(new Estate("Museumstraße", propertyGroup, new int[]{9999}));
        fields.add(new Estate("Opernplatzstraße", propertyGroup, new int[]{9999}));
        fields.add(new Trainstation("Nordbahnhof"));
        propertyGroup = new PropertyGroup("yellow","#FFFF00");
        fields.add(new Estate("Lessingstraße", propertyGroup, new int[]{9999}));
        fields.add(new Estate("Schillerstraße", propertyGroup, new int[]{9999}));
        fields.add(new PublicInfrastructure("Wasserwerk"));
        fields.add(new Estate("Goethestraße", propertyGroup, new int[]{9999}));
        fields.add(new ActionField()); //todo Gehen Sie in das Gefängnis
        propertyGroup = new PropertyGroup("green","#04B404");
        fields.add(new Estate("Rathausplatz", propertyGroup, new int[]{9999}));
        fields.add(new Estate("Hauptstraße", propertyGroup, new int[]{9999}));
        fields.add(new ActionField()); //todo Gemeinschaftsfeld
        fields.add(new Estate("Bahnhofsstraße", propertyGroup, new int[]{9999}));
        fields.add(new Trainstation("Hauptbahnhof"));
        fields.add(new ActionField()); //todo Ereigniskarte
        propertyGroup = new PropertyGroup("blue","#0101DF");
        fields.add(new Estate("Parkstraße", propertyGroup, new int[]{9999}));
        fields.add(new ActionField()); //todo Zusatzsteuer
        fields.add(new Estate("Schlossallee", propertyGroup, new int[]{9999}));
    }

    public Field getFieldAtIndex(int index){
        //todo
        return null;
    }
}
