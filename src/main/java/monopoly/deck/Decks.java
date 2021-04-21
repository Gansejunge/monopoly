package monopoly.deck;

import java.util.HashMap;
import java.util.Map;

public class Decks {
    private Map<CardType, Deck> decks;


    public Decks() {
        decks = new HashMap<>();
        decks.put(CardType.Ereigniskarte, initializeActionCardDeck());
        decks.put(CardType.Gemeinschaftskarte, initializeCommunityCards());
    }

    public Card drawCard(CardType cardType) {
        return getDeck(cardType).drawCard();
    }

    public Deck getDeck(CardType type){
        return decks.get(type);
    }

    public Deck initializeActionCardDeck() {
        Deck actionCards = new Deck();
        actionCards.add(new Card("Rücken Sie vor bis zur Schlossallee.", new MoveToLocation(39, true), CardType.Ereigniskarte));
        actionCards.add(new Card("Machen Sie einen Ausflug zum Südbahnhof. Wenn Sie über Los kommen, ziehen Sie € 4000 ein.", new MoveToLocation(5, true), CardType.Ereigniskarte));
        actionCards.add(new Card("Ihr Bausparvertrag wird fällig. Sie erhalten € 4000.", new GetMoneyAction(4000), CardType.Ereigniskarte));
        actionCards.add(new Card("Rücken Sie vor bis zum Opernplatz. Wenn Sie über Los kommen, ziehen Sie € 4000 ein.", new MoveToLocation(24, true), CardType.Ereigniskarte));
        actionCards.add(new Card("Rücken Sie vor bis zum nächsten Versorgungswerk. Werfen Sie die Würfel und zahlen dem Eigentümer den zehnfachen\n" +
                "Betrag Ihres Wurfergebnisses. Wenn das Werk noch niemandem gehört, können Sie es von der Bank kaufen.", new MoveToLocationWhilePossiblyPayingHigherRent(new int[]{12, 28}, 10), CardType.Ereigniskarte));
        actionCards.add(new Card("Gehen Sie in das Gefängnis. Begeben Sie sich direkt dorthin. Gehen Sie nicht über Los. Ziehen Sie nicht € 4000 ein.", new GoToPrison(), CardType.Ereigniskarte));
        actionCards.add(new Card("Rücken Sie vor bis auf Los. (Ziehe € 4000 ein).", new MoveToLocation(0, true), CardType.Ereigniskarte));
        actionCards.add(new Card("Die Bank zahlt Ihnen eine Dividende von € 1000.", new GetMoneyAction(1000), CardType.Ereigniskarte));
        actionCards.add(new Card("Sie lassen Ihre Häuser renovieren. Zahlen Sie: € 500 pro Haus, € 2000 pro Hotel.", new MaintainOwnedEstate(500, 2000), CardType.Ereigniskarte));
        actionCards.add(new Card("Sie kommen aus dem Gefängnis frei! Behalten Sie diese Karte, bis Sie sie benötigen oder verkaufen.", new EscapePrison(), CardType.Ereigniskarte));
        actionCards.add(new Card("Rücken Sie vor bis zur Seestraße. Wenn Sie über Los kommen, ziehen Sie € 4000 ein.", new MoveToLocation(11, true), CardType.Ereigniskarte));
        actionCards.add(new Card("Sie sind zum Vorstand gewählt worden. Zahlen Sie jedem Spieler € 1000.", new RedistributeMoneyToOrFromCurrentPlayer(-1000), CardType.Ereigniskarte));
        actionCards.add(new Card("Ihr Bausparvertrag wird fällig. Sie erhalten € 4000.", new GetMoneyAction(4000), CardType.Ereigniskarte));
        actionCards.add(new Card("Gehen Sie 3 Felder zurück.", new MoveFields(-3), CardType.Ereigniskarte));
        actionCards.add(new Card("Strafzettel! Zahlen Sie € 300.", new GetMoneyAction(-300), CardType.Ereigniskarte));
        actionCards.add(new Card("Rücken Sie vor bis zum nächsten Bahnhof. Der Eigentümer erhält das Doppelte der normalen Miete.\n" +
                "Wenn der Bahnhof noch niemandem gehört, können Sie ihn von der Bank kaufen.", new MoveToLocationWhilePossiblyPayingHigherRent(new int[]{5, 15, 25, 35}, 2), CardType.Ereigniskarte));

        actionCards.reshuffle();
        return actionCards;
    }

    public Deck initializeCommunityCards(){
        Deck communityCards = new Deck();
        communityCards.add(new Card("Sie kommen aus dem Gefängnis frei! Behalten Sie diese Karte, bis Sie sie benötigen oder verkaufen.", new EscapePrison(), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Schulgeld. Zahlen Sie € 1000.", new GetMoneyAction(-50), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Urlaubsgeld! Sie erhalten € 2000.", new GetMoneyAction(100), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Ihre Lebensversicherung wird fällig. Sie erhalten € 2000", new GetMoneyAction(100), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Arzt-Kosten. Zahlen Sie € 1000", new GetMoneyAction(-50), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Einkommenssteuerrückerstattung. Sie erhalten € 400.", new GetMoneyAction(20), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Krankenhausgebühren. Zahlen Sie € 2000", new GetMoneyAction(-100), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Gehen Sie in das Gefängnis. Begeben Sie sich direkt dorthin. Gehen Sie nicht über Los. Ziehen Sie nicht € 4000 ein.", new GoToPrison(), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Sie erhalten auf Vorzugs-Aktien 7% Dividende: € 500.", new GetMoneyAction(25), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Sie haben Geburtstag. Jeder Spieler schenkt Ihnen € 200", new RedistributeMoneyToOrFromCurrentPlayer(10), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Sie erben € 2000", new GetMoneyAction(100), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Aus Lagerverkäufen erhalten Sie M 1000", new GetMoneyAction(50), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Zweiter Preis im Schönheitswettbewerb. Sie erhalten € 200.", new GetMoneyAction(10), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Sie werden zu Straßenausbesserungsarbeiten herangezogen. Zahlen Sie € 800 je Haus und € 2300 je Hotel an die Bank.", new MaintainOwnedEstate(40, 115), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Rücken Sie vor bis auf Los. (Ziehe € 4000 ein).", new MoveToLocation(0, true), CardType.Gemeinschaftskarte));
        communityCards.add(new Card("Bank-Irrtum zu Ihren Gunsten. Ziehen Sie € 4000 ein", new GetMoneyAction(200), CardType.Gemeinschaftskarte));

        communityCards.reshuffle();
        return communityCards;
    }
}
