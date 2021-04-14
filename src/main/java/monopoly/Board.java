package monopoly;

import monopoly.deck.*;
import monopoly.field.*;

import java.util.ArrayList;
import java.util.List;


public class Board {
    private List<Field> fields;
    private PropertyGroup propertyGroup;
    public Board(){
        fields = new ArrayList<>();
        initBoard();
    }

    public List<Field> getAllFields(){
        return fields;
    }

    public BoardMoveResult movePlayer(Player player, int step){
        boolean passedGo = step + player.getPosition() > fields.size();
        int resultingPosition = (player.getPosition() + step) % fields.size();
        player.setPosition(resultingPosition);
        return new BoardMoveResult(fields.get(resultingPosition), passedGo);
    }

    private void initBoard(){
        PropertyGroup trainStations = new PropertyGroup("trainstations", "#FFF");
        PropertyGroup works = new PropertyGroup("electricity", "#FFF");

        fields.add(new Go("Los", new NullAction()));
        propertyGroup = new PropertyGroup("brown","#A52A2A");
        fields.add(new Estate("Badstraße", propertyGroup, 1200, new int[]{40, 200, 600, 1800, 3200, 5000}, 1000, new FieldAction()));
        fields.add(new ActionField("Gemeinschaftsfeld", new DrawCommunityCard()));
        fields.add(new Estate("Turmstraße", propertyGroup, 1200, new int[]{80, 400, 1200, 3600, 6400, 9000}, 1000, new FieldAction()));
        fields.add(new ActionField("Einkommenssteuer", new AdditionalTax(2000)));
        fields.add(new Trainstation("Südbahnhof", trainStations, 4000, new FieldAction()));
        propertyGroup = new PropertyGroup("lightblue","#00FFFF");
        fields.add(new Estate("Chaussestrasse", propertyGroup, 2000, new int[]{120, 600, 1800, 5400, 8000, 11000}, 1000, new FieldAction()));
        fields.add(new ActionField("Ereigniskarte", new DrawActionCard()));
        fields.add(new Estate("Elisenstraße", propertyGroup, 2000, new int[]{120, 600, 1800, 5400, 8000, 11000}, 1000, new FieldAction()));
        fields.add(new Estate("Poststraße", propertyGroup, 2400, new int[]{160, 800, 2000, 6000, 9000, 12000}, 1000, new FieldAction()));
        fields.add(new Prison("Gefängnis", new NullAction()));
        propertyGroup = new PropertyGroup("purple","#8904B1");
        fields.add(new Estate("Seestraße", propertyGroup, 2800, new int[]{200, 1000, 3000, 9000, 12500, 15000}, 2000, new FieldAction()));
        fields.add(new PublicInfrastructure("Elektrizitätswerk", works, 4000, new FieldAction()));
        fields.add(new Estate("Hafenstraße", propertyGroup, 2800, new int[]{200, 1000, 3000, 9000, 12500, 15000}, 2000, new FieldAction()));
        fields.add(new Estate("Neue Straße", propertyGroup, 3200, new int[]{240, 1200, 3600, 10000, 14000, 18000}, 2000, new FieldAction()));
        fields.add(new Trainstation("Westbahnhof", trainStations, 4000, new FieldAction()));
        propertyGroup = new PropertyGroup("orange","#FF8000");
        fields.add(new Estate("Münchener Straße", propertyGroup, 3600, new int[]{280, 1400, 4000, 11000, 15000, 19000}, 2000, new FieldAction()));
        fields.add(new ActionField("Gemeinschaftsfeld", new DrawCommunityCard()));
        fields.add(new Estate("Wiener Straße", propertyGroup, 3600, new int[]{280, 1400, 4000, 11000, 15000, 19000}, 2000, new FieldAction()));
        fields.add(new Estate("Berliner Straße", propertyGroup, 4000, new int[]{320, 1600, 4400, 12000, 16000, 20000}, 2000, new FieldAction()));
        fields.add(new ActionField("Frei parken", new NullAction()));
        propertyGroup = new PropertyGroup("red","#DF0101");
        fields.add(new Estate("Theaterstraße", propertyGroup, 4400, new int[]{360, 1800, 5000, 14000, 17500, 21000},3000, new FieldAction()));
        fields.add(new ActionField("Ereigniskarte", new DrawActionCard()));
        fields.add(new Estate("Museumstraße", propertyGroup, 4400, new int[]{360, 1800, 5000, 14000, 17500, 21000}, 3000, new FieldAction()));
        fields.add(new Estate("Opernplatzstraße", propertyGroup, 4800, new int[]{400, 2000, 6000, 15000, 18500, 22000}, 3000, new FieldAction()));
        fields.add(new Trainstation("Nordbahnhof", trainStations, 4000, new FieldAction()));
        propertyGroup = new PropertyGroup("yellow","#FFFF00");
        fields.add(new Estate("Lessingstraße", propertyGroup, 5200, new int[]{480, 2200, 6600, 16000, 19500, 23000}, 3000, new FieldAction()));
        fields.add(new Estate("Schillerstraße", propertyGroup, 5200, new int[]{480, 2200, 6600, 16000, 19500, 23000}, 3000, new FieldAction()));
        fields.add(new PublicInfrastructure("Wasserwerk", works, 4000, new FieldAction()));
        fields.add(new Estate("Goethestraße", propertyGroup, 5600, new int[]{580, 2400, 7200, 17000, 20500, 24000}, 3000, new FieldAction()));
        fields.add(new ActionField("Gehen Sie in das Gefängis", new GoToPrison()));
        propertyGroup = new PropertyGroup("green","#04B404");
        fields.add(new Estate("Rathausplatz", propertyGroup, 6000, new int[]{520, 2600, 7800, 18000, 22000, 25500}, 4000, new FieldAction()));
        fields.add(new Estate("Hauptstraße", propertyGroup, 6000, new int[]{520, 2600, 7800, 18000, 22000, 25500}, 4000, new FieldAction()));
        fields.add(new ActionField("Gemeinschaftsfeld", new DrawCommunityCard()));
        fields.add(new Estate("Bahnhofsstraße", propertyGroup, 6400, new int[]{560, 3000, 9000, 20000, 24000, 28000}, 4000, new FieldAction()));
        fields.add(new Trainstation("Hauptbahnhof", trainStations, 4000, new FieldAction()));
        fields.add(new ActionField("Ereigniskarte", new DrawActionCard()));
        propertyGroup = new PropertyGroup("blue","#0101DF");
        fields.add(new Estate("Parkstraße", propertyGroup, 7000, new int[]{700, 3500, 10000, 22000, 26000, 30000}, 4000, new FieldAction()));
        fields.add(new ActionField("Zusatzsteuer", new AdditionalTax(4000)));
        fields.add(new Estate("Schlossallee", propertyGroup, 8000, new int[]{1000, 4000, 12000, 28000, 34000, 40000}, 4000, new FieldAction()));
    }

    public Field getFieldAtIndex(int index){
        return this.fields.get(index);
    }
}
