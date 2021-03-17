package monopoly;

import monopoly.deck.Card;
import monopoly.field.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private int money = 0;
    private int position = 0;
    private boolean isInPrison;
    private int turnsInPrison;
    private ArrayList<Property> properties = new ArrayList<>();
    private ArrayList<Card> Card= new ArrayList<>();

    public Player(String name){
        this.name = name;
    }

    public void addTurnInPrison(){
        turnsInPrison++;
    }

    public int getTurnsInPrison(){
        return turnsInPrison;
    }

    public void setInPrison(boolean isInPrison){
        this.isInPrison = isInPrison;
        if(! this.isInPrison){
            turnsInPrison = 0;
        }
    }

    public boolean isInPrison(){
        return isInPrison;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getMoney() {
        return this.money;
    }

    public List<Property> getProperties() {
        return this.properties;
    }

    public ArrayList<monopoly.deck.Card> getCard() {
        return this.Card;
    }

    public double insertBid(double bid){
        Scanner inputScanner = new Scanner(System.in);
        System.out.printf("Geben Sie ein Gebot ein. Es muss größer als sein als %f", bid);
        Double tempBid = 0.0;
       do{
           System.out.printf("%s, bitte geben Sie ein Gebot ein. Es muss größer als sein als %f", this.name, bid);
           tempBid = inputScanner.nextDouble();
       }
       while(tempBid < bid || tempBid == 0);
       return tempBid;
    }
}
