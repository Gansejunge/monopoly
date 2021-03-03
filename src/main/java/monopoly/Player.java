package monopoly;

import monopoly.deck.Card;
import monopoly.field.Estate;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private int money = 0;
    private int position = 0;
    private ArrayList<Estate> Estate= new ArrayList<>();
    private ArrayList<Card> Card= new ArrayList<>();
    private int amountOfHouses;
    private int amountOfHotels;

    public int getAmountOfHouses() {
        return this.amountOfHouses;
    }

    public int getAmountOfHotels() {
        return this.amountOfHotels;
    }

    public Player(String name){
        this.name = name;
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

    public ArrayList<monopoly.field.Estate> getEstate() {
        return this.Estate;
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
