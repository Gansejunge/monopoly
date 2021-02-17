package monopoly.deck;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> actionCards = new ArrayList<>();
    private ArrayList<Card> communityCards = new ArrayList<>();
    private ArrayList<Card> graveyardActionCards = new ArrayList<>();
    private ArrayList<Card> graveyardCommunityCards = new ArrayList<>();

    public Deck() {
        this.initializeCardDeck();
    }

    public void initializeCardDeck() {
        actionCards.add(new Card("Rücken Sie vor bis zur Schlossallee.", new MoveToLocation(39, true), CardType.Ereigniskarte));
        actionCards.add(new Card("Machen Sie einen Ausflug zum Südbahnhof. Wenn Sie über Los kommen, ziehen Sie € 200 ein.", new MoveToLocation(5, true), CardType.Ereigniskarte));
        actionCards.add(new Card("Ihr Bausparvertrag wird fällig. Sie erhalten € 200.", new GetMoneyAction(200), CardType.Ereigniskarte));
        actionCards.add(new Card("Rücken Sie vor bis zum Opernplatz. Wenn Sie über Los kommen, ziehen Sie € 200 ein.", new MoveToLocation(24, true), CardType.Ereigniskarte));
        actionCards.add(new Card("Rücken Sie vor bis zum nächsten Versorgungswerk. Werfen Sie die Würfel und zahlen dem Eigentümer den zehnfachen\n" +
                "Betrag Ihres Wurfergebnisses. Wenn das Werk noch niemandem gehört, können Sie es von der Bank kaufen.", new MoveToLocationWhilePossiblyPayingHigherRent(new int[]{12, 28}, 10), CardType.Ereigniskarte));
        actionCards.add(new Card("Gehen Sie in das Gefängnis. Begeben Sie sich direkt dorthin. Gehen Sie nicht über Los. Ziehen Sie nicht € 200 ein.", new MoveToLocation(10, false), CardType.Ereigniskarte));
        actionCards.add(new Card("Rücken Sie vor bis auf Los. (Ziehe € 200 ein).", new MoveToLocation(0, true), CardType.Ereigniskarte));
        actionCards.add(new Card("Die Bank zahlt Ihnen eine Dividende von € 50.", new GetMoneyAction(50), CardType.Ereigniskarte));
        actionCards.add(new Card("Sie lassen Ihre Häuser renovieren. Zahlen Sie: € 25 pro Haus, € 100 pro Hotel.", new MaintainOwnedEstate(25, 100), CardType.Ereigniskarte));
        actionCards.add(new Card("Sie kommen aus dem Gefängnis frei! Behalten Sie diese Karte, bis Sie sie benötigen oder verkaufen.", new EscapePrison(), CardType.Ereigniskarte));
        actionCards.add(new Card("Rücken Sie vor bis zur Seestraße. Wenn Sie über Los kommen, ziehen Sie € 200 ein.", new MoveToLocation(11, true), CardType.Ereigniskarte));
        actionCards.add(new Card("Sie sind zum Vorstand gewählt worden. Zahlen Sie jedem Spieler € 50.", new RedistributeMoneyToOrFromCurrentPlayer(-50), CardType.Ereigniskarte));
        actionCards.add(new Card("Ihr Bausparvertrag wird fällig. Sie erhalten € 200.", new GetMoneyAction(200), CardType.Ereigniskarte));
        actionCards.add(new Card("Gehen Sie 3 Felder zurück.", new MoveFields(-3), CardType.Ereigniskarte));
        actionCards.add(new Card("Strafzettel! Zahlen Sie € 15.", new GetMoneyAction(-15), CardType.Ereigniskarte));
        actionCards.add(new Card("Rücken Sie vor bis zum nächsten Verkehrsfeld. Der Eigentümer erhält das Doppelte der normalen Miete.\n" +
                "Wenn das Verkehrsfeld noch niemandem gehört, können Sie es von der Bank kaufen.", new MoveToLocationWhilePossiblyPayingHigherRent(new int[]{5, 15, 25, 35}, 2), CardType.Ereigniskarte));
        communityCards.add(new Card("Sie kommen aus dem Gefängnis frei! Behalten Sie diese Karte, bis Sie sie benötigen oder verkaufen.", new EscapePrison(), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Schulgeld. Zahlen Sie € 50.", new GetMoneyAction(-50), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Urlaubsgeld! Sie erhalten € 100.", new GetMoneyAction(100), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Ihre Lebensversicherung wird fällig. Sie erhalten € 100", new GetMoneyAction(100), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Arzt-Kosten. Zahlen Sie € 50", new GetMoneyAction(-50), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Einkommenssteuerrückerstattung. Sie erhalten € 20.", new GetMoneyAction(20), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Krankenhausgebühren. Zahlen Sie € 100", new GetMoneyAction(-100), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Gehen Sie in das Gefängnis. Begeben Sie sich direkt dorthin. Gehen Sie nicht über Los. Ziehen Sie nicht € 200 ein.", new MoveToLocation(10, false), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Sie erhalten auf Vorzugs-Aktien 7% Dividende: € 25.", new GetMoneyAction(25), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Sie haben Geburtstag. Jeder Spieler schenkt Ihnen € 10", new RedistributeMoneyToOrFromCurrentPlayer(10), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Sie erben € 100", new GetMoneyAction(100), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Aus Lagerverkäufen erhalten Sie M 50", new GetMoneyAction(50), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Zweiter Preis im Schönheitswettbewerb. Sie erhalten € 10.", new GetMoneyAction(10), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Sie werden zu Straßenausbesserungsarbeiten herangezogen. Zahlen Sie € 40 je Haus und € 115 je Hotel an die Bank.", new MaintainOwnedEstate(40, 115), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Rücken Sie vor bis auf Los. (Ziehe € 200 ein).", new MoveToLocation(0, true), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Bank-Irrtum zu Ihren Gunsten. Ziehen Sie € 200 ein", new GetMoneyAction(200), CardType.Gemeinschaftskarte));
        Collections.shuffle(communityCards);
        Collections.shuffle(actionCards);
    }

    public void clearOutCardGraveyard(CardType cardType) {
        if (cardType == CardType.Ereigniskarte) {
            this.communityCards = graveyardCommunityCards;
            return;
        }
        this.actionCards = graveyardActionCards;
    }

    public void addCardToGraveyard(Card card) {
        if (card.getCardType() == CardType.Ereigniskarte) {
            graveyardActionCards.add(card);
            return;
        }
        graveyardCommunityCards.add(card);
    }

    public Card drawCard(CardType cardType) {
        if (!this.communityCards.isEmpty() && cardType == CardType.Ereigniskarte)
            return this.communityCards.remove(0);
        if (!this.actionCards.isEmpty() && cardType == CardType.Gemeinschaftskarte)
            return this.actionCards.remove(0);
        this.clearOutCardGraveyard(cardType);
        this.drawCard(cardType);
        return null;
    }
}
