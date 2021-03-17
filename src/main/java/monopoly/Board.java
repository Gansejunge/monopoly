package monopoly;

import monopoly.field.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Field> fields;

    public Board(){
        fields = new ArrayList<>();
        initBoard();
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
        fields.add(new Estate("Badstraße", "brown", new int[]{9999}));
        fields.add(new ActionField()); //todo Gemeinschaftsfeld
        fields.add(new Estate("Turmstraße", "brown", new int[]{9999}));
        fields.add(new ActionField()); //todo Einkommenssteuer
        fields.add(new Trainstation("Südbahnhof"));
        fields.add(new Estate("Chaussestrasse", "lightblue", new int[]{9999}));
        fields.add(new ActionField()); //todo Ereigniskarte
        fields.add(new Estate("Elisenstraße", "lightblue", new int[]{9999}));
        fields.add(new Estate("Poststraße", "lightblue", new int[]{9999}));
        fields.add(new Prison());
        fields.add(new Estate("Seestraße", "purple", new int[]{9999}));
        fields.add(new PublicInfrastructure("Elektrizitätswerk"));
        fields.add(new Estate("Hafenstraße", "purple", new int[]{9999}));
        fields.add(new Estate("Neue Straße", "purple", new int[]{9999}));
        fields.add(new Trainstation("Westbahnhof"));
        fields.add(new Estate("Münchener Straße", "orange", new int[]{9999}));
        fields.add(new ActionField()); //todo Gemeinschaftsfeld
        fields.add(new Estate("Wiener Straße", "orange", new int[]{9999}));
        fields.add(new Estate("Berliner Straße", "orange", new int[]{9999}));
        fields.add(new ActionField()); //todo frei parken
        fields.add(new Estate("Theaterstraße", "red", new int[]{9999}));
        fields.add(new ActionField()); //todo Ereigniskarte
        fields.add(new Estate("Museumstraße", "red", new int[]{9999}));
        fields.add(new Estate("Opernplatzstraße", "red", new int[]{9999}));
        fields.add(new Trainstation("Nordbahnhof"));
        fields.add(new Estate("Lessingstraße", "yellow", new int[]{9999}));
        fields.add(new Estate("Schillerstraße", "yellow", new int[]{9999}));
        fields.add(new PublicInfrastructure("Wasserwerk"));
        fields.add(new Estate("Goethestraße", "yellow", new int[]{9999}));
        fields.add(new ActionField()); //todo Gehen Sie in das Gefängnis
        fields.add(new Estate("Rathausplatz", "green", new int[]{9999}));
        fields.add(new Estate("Hauptstraße", "green", new int[]{9999}));
        fields.add(new ActionField()); //todo Gemeinschaftsfeld
        fields.add(new Estate("Bahnhofsstraße", "green", new int[]{9999}));
        fields.add(new Trainstation("Hauptbahnhof"));
        fields.add(new ActionField()); //todo Ereigniskarte
        fields.add(new Estate("Parkstraße", "blue", new int[]{9999}));
        fields.add(new ActionField()); //todo Zusatzsteuer
        fields.add(new Estate("Schlossallee", "blue", new int[]{9999}));
    }

    public Field getFieldAtIndex(int index){
        //todo
        return null;
    }
}
