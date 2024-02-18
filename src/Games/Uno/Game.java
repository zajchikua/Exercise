package Games.Uno;

import javax.swing.*;
import java.awt.*;
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

        if (card.getValue() == UnoCard.Value.Wild || card.getValue() == UnoCard.Value.Wild_Four
                || card.getValue() == UnoCard.Value.DrawTwo)
        {
            start(game);
        }

        if (card.getValue() == UnoCard.Value.Skip) {
            JLabel message = new JLabel(playersIds[currentPlayer] + " was skipped.");
            message.setFont(new Font("Calibri", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);

            if (gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playersIds.length;
            }
            else if (gameDirection == true) {
                currentPlayer = (currentPlayer - 1) % playersIds.length;
                if(currentPlayer == -1){
                    currentPlayer = playersIds.length -1;
                }
            }
        }

        if(card.getValue() == UnoCard.Value.Reverse)
        {
            JLabel message = new JLabel(playersIds[currentPlayer] + " has reversed the game.");
            message.setFont(new Font("Calibri", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            gameDirection ^= true;
            currentPlayer = playersIds.length - 1;
        }

        stockpile.add(card);
    }

    public UnoCard getTopCard()
    {    return new UnoCard(validColor, validValue);
    }

    public ImageIcon getTopCardImage()
    {
        return new ImageIcon(validColor + "-" + validValue + ".png");
    }

    public boolean isGameOver()
    {
        for(String player : this.playersIds)
        {
            if(hasEmptyHand(player))
            {
                return true;
            }
        }
        return false;
    }

    public String getCurrentPlayer()
    {
        return this.playersIds[this.currentPlayer];
    }

    public String getPreviousPlayer(int i)
    {
        int index = this.currentPlayer - i;
        if (index == -1 )
        {
            index = playersIds.length -1;
        }
        return this.playersIds[index];
    }

    public String[] getPlayers()
    {
        return playersIds;
    }
    public ArrayList<UnoCard> getPlayerHand(String playerId)
    {
        int index = Arrays.asList(playersIds).indexOf(playerId);
        return playerHand.get(index);
    }

    public int getPlayerHandSize(String playerId)
    {
        return getPlayerHand(playerId).size();
    }

    public UnoCard getPlayerCard(String playerId, int choice)
    {
        ArrayList<UnoCard> hand = getPlayerHand(playerId);
        return hand.get(choice);
    }

    public boolean hasEmptyHand(String playerId)
    {
        return getPlayerHand(playerId).isEmpty();
    }

    public boolean validCardPlay(UnoCard card)
    {
        return card.getColor() == validColor || card.getValue() == validValue;
    }

    public boolean checkPlayerTurn(String playerId) throws InvalidPlayerIdException
    {
        if(this.playersIds[this.currentPlayer] != playerId){
            throw new InvalidPlayerIdException("It is not " + playerId +
                    "'s turn.");
        }

    }
}
