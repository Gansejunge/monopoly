import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> actionCards = new ArrayList<>();
    private ArrayList<Card> communityCard = new ArrayList<>();
    public void initializeCardDeck(){
        this.actionCards.clear();
        actionCards.add(new Card("Sie kommen aus dem Gefängnis frei! Behalten Sie diese Karte, bis Sie sie benötigen oder verkaufen.",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Schulgeld. Zahlen Sie € 50.",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Urlaubsgeld! Sie erhalten € 100",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Ihre Lebensversicherung wird fällig. Sie erhalten € 100",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Arzt-Kosten. Zahlen Sie € 50",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Einkommenssteuerrückerstattung. Sie erhalten € 20",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Krankenhausgebühren. Zahlen Sie € 100",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Gehen Sie in das Gefängnis. Begeben Sie sich direkt dorthin. Gehen Sie nicht über Los. Ziehen Sie nicht € 200 ein",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Sie erhalten auf Vorzugs-Aktien 7% Dividende: € 25",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Sie haben Geburtstag. Jeder Spieler schenkt Ihnen € 10.",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Sie erben € 100.",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Sie erben € 100.",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Zweiter Preis im Schönheitswettbewerb. Sie erhalten € 10",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Sie werden zu Straßenausbesserungsarbeiten herangezogen. Zahlen Sie € 40 je Haus und € 115 je Hotel an die Bank.",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Rücken Sie vor bis auf Los. (Ziehe € 200 ein).",null,CardType.Ereigniskarte));
        actionCards.add(new Card("Bank-Irrtum zu Ihren Gunsten. Ziehen Sie € 200 ein.",null,CardType.Ereigniskarte));

        this.communityCard.clear();
        communityCard.add(new Card("Sie kommen aus dem Gefängnis frei! Behalten Sie diese Karte, bis Sie sie benötigen oder verkaufen.",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Schulgeld. Zahlen Sie € 50.",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Urlaubsgeld! Sie erhalten € 100.",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Ihre Lebensversicherung wird fällig. Sie erhalten € 100",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Arzt-Kosten. Zahlen Sie € 50",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Einkommenssteuerrückerstattung. Sie erhalten € 20.",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Krankenhausgebühren. Zahlen Sie € 100",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Gehen Sie in das Gefängnis. Begeben Sie sich direkt dorthin. Gehen Sie nicht über Los. Ziehen Sie nicht € 200 ein.",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Sie erhalten auf Vorzugs-Aktien 7% Dividende: € 25.",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Sie haben Geburtstag. Jeder Spieler schenkt Ihnen € 10",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Sie erben € 100",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Sie erben € 100",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Zweiter Preis im Schönheitswettbewerb. Sie erhalten € 10.",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Sie werden zu Straßenausbesserungsarbeiten herangezogen. Zahlen Sie € 40 je Haus und € 115 je Hotel an die Bank.",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Rücken Sie vor bis auf Los. (Ziehe € 200 ein).",null,CardType.Gemeinschaftskarte));
        communityCard.add(new Card("Bank-Irrtum zu Ihren Gunsten. Ziehen Sie € 200 ein",null,CardType.Gemeinschaftskarte));
        Collections.shuffle(communityCard);
        Collections.shuffle(actionCards);
    }
    public Deck(){
        this.initializeCardDeck();
    }
}
