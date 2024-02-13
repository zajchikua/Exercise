package Games.Uno;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private int currentPlayer;
    private String[] playersIds;

    private UnoDeck deck;
    private ArrayList<ArrayList<UnoCard>> playerHand;
    private ArrayList<UnoCard> stockpile;

    private UnoCard.Color validColor;
    private UnoCard.Value validValue;

    boolean gameDirection;

    public Game(String[] pids)
    {
        deck = new UnoDeck();
        deck.shuffle();
        stockpile = new ArrayList<UnoCard>();

        playersIds = pids;
        currentPlayer = 0;
        gameDirection = false;

        playerHand = new ArrayList<ArrayList<UnoCard>>();
        //fill up the players with uno cards
        for(int i = 0; i < pids.length; i++)
        {
           ArrayList<UnoCard> hand = new ArrayList<UnoCard>(Arrays.asList(deck.drawCard(7)));
           playerHand.add(hand);
        }
    }

    public void start(Game game)
    {
        UnoCard card = deck.drawCard();
        validColor = card.getColor();
        validValue = card.getValue();

        if (card.getValue() == UnoCard.Value.Wild_Four ||card.getValue() == UnoCard.Value.DrawTwo)
        {
            start(game);
        }



    }
}
