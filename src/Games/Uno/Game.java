package Games.Uno;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private int currentPlayer;
    private String[] playersIds;

    private UnoDeck deck;
    private ArrayList< ArrayList< UnoCard > > playerHand;
    private ArrayList< UnoCard > stockpile;

    private UnoCard.Color validColor;
    private UnoCard.Value validValue;

    boolean gameDirection;

    public Game ( String[] pids ) {
        deck = new UnoDeck();
        deck.shuffle();
        stockpile = new ArrayList< UnoCard >();

        playersIds = pids;
        currentPlayer = 0;
        gameDirection = false;

        playerHand = new ArrayList< ArrayList< UnoCard > >();
        //fill up the players with uno cards
        for (int i = 0; i < pids.length; i++) {
            ArrayList< UnoCard > hand = new ArrayList< UnoCard >(Arrays.asList(deck.drawCard(7)));
            playerHand.add(hand);
        }
    }

    public void start ( Game game ) {
        UnoCard card = deck.drawCard();
        validColor = card.getColor();
        validValue = card.getValue();

        if (card.getValue() == UnoCard.Value.Wild || card.getValue() == UnoCard.Value.Wild_Four
                || card.getValue() == UnoCard.Value.DrawTwo) {
            start(game);
        }

        if (card.getValue() == UnoCard.Value.Skip) {
            JLabel message = new JLabel(playersIds[currentPlayer] + " was skipped.");
            message.setFont(new Font("Calibri", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);

            if (gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playersIds.length;
            } else if (gameDirection == true) {
                currentPlayer = (currentPlayer - 1) % playersIds.length;
                if (currentPlayer == -1) {
                    currentPlayer = playersIds.length - 1;
                }
            }
        }

        if (card.getValue() == UnoCard.Value.Reverse) {
            JLabel message = new JLabel(playersIds[currentPlayer] + " has reversed the game.");
            message.setFont(new Font("Calibri", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            gameDirection ^= true;
            currentPlayer = playersIds.length - 1;
        }

        stockpile.add(card);
    }

    public UnoCard getTopCard ( ) {
        return new UnoCard(validColor, validValue);
    }

    public ImageIcon getTopCardImage ( ) {
        return new ImageIcon(validColor + "-" + validValue + ".png");
    }

    public boolean isGameOver ( ) {
        for (String player : this.playersIds) {
            if (hasEmptyHand(player)) {
                return true;
            }
        }
        return false;
    }

    public String getCurrentPlayer ( ) {
        return this.playersIds[this.currentPlayer];
    }

    public String getPreviousPlayer ( int i ) {
        int index = this.currentPlayer - i;
        if (index == -1) {
            index = playersIds.length - 1;
        }
        return this.playersIds[index];
    }

    public String[] getPlayers ( ) {
        return playersIds;
    }

    public ArrayList< UnoCard > getPlayerHand ( String playerId ) {
        int index = Arrays.asList(playersIds).indexOf(playerId);
        return playerHand.get(index);
    }

    public int getPlayerHandSize ( String playerId ) {
        return getPlayerHand(playerId).size();
    }

    public UnoCard getPlayerCard ( String playerId, int choice ) {
        ArrayList< UnoCard > hand = getPlayerHand(playerId);
        return hand.get(choice);
    }

    public boolean hasEmptyHand ( String playerId ) {
        return getPlayerHand(playerId).isEmpty();
    }

    public boolean validCardPlay ( UnoCard card ) {
        return card.getColor() == validColor || card.getValue() == validValue;
    }

    public boolean checkPlayerTurn ( String playerId ) throws InvalidPlayerTurnException {
        if (this.playersIds[this.currentPlayer] != playerId) {
            throw new InvalidPlayerTurnException("It is not " + playerId +
                    "'s turn.", playerId);
        }
        return true;
    }

    public boolean submitDraws ( String playerId ) throws InvalidPlayerTurnException {
        checkPlayerTurn(playerId);
        if (deck.isEmpty()) {
            deck.replaceDeckWith(stockpile);
            deck.shuffle();
        }
        getPlayerHand(playerId).add(deck.drawCard());
        if (gameDirection == false) {
            currentPlayer = (currentPlayer + 1) % playersIds.length;
        } else if (gameDirection == true) {
            currentPlayer = (currentPlayer - 1) % playersIds.length;
            if (currentPlayer == -1) {
                currentPlayer = playersIds.length - 1;
            }
        }
        return true;
    }

    public void setCardColor ( UnoCard.Color color ) {
        validColor = color;
    }

    public void submitPlayerCard ( String pid, UnoCard card, UnoCard.Color declaredColor )
            throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException {
        checkPlayerTurn(pid);

        ArrayList< UnoCard > hand = getPlayerHand(pid);
        if (!validCardPlay(card)) {
            if (card.getColor() == UnoCard.Color.Wild) {
                validColor = card.getColor();
                validValue = card.getValue();
            }
            if (card.getColor() != validColor) {
                JLabel message = new JLabel("Invalid player move, expected color: " +
                        validColor + " , but got color " + card.getColor());
                message.setFont(new Font("Calibri", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                throw new InvalidColorSubmissionException(message.getText(), card.getColor(), validColor);
            } else if (card.getValue() != validValue) {
                JLabel message = new JLabel("Invalid player move, expected value: " +
                        validValue + " , but got value " + card.getValue());
                message.setFont(new Font("Calibri", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                throw new InvalidValueSubmissionException(message.getText(), card.getValue(), validValue);
            }
        }
        playerHand.remove(card);
        if (hasEmptyHand(this.playersIds[currentPlayer])) {
            JLabel message2 = new JLabel("This player " + this.playersIds[currentPlayer]
                    + " has won! Thanks for playing!");
            message2.setFont(new Font("Calibri", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message2);
            System.exit(0);
        }
        validColor = card.getColor();
        validValue = card.getValue();
        stockpile.add(card);

        if (gameDirection == false) {
            currentPlayer = (currentPlayer + 1) % playersIds.length;
        } else if (gameDirection == true) {
            currentPlayer = (currentPlayer - 1) % playersIds.length;
            if (currentPlayer == -1) {
                currentPlayer = playersIds.length - 1;
            }
        }

        if (card.getColor() == UnoCard.Color.Wild) {
            validColor = declaredColor;
        }
        if (card.getValue() == UnoCard.Value.DrawTwo) {
            pid = playersIds[currentPlayer];
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            JLabel message = new JLabel(pid + " drew 2 cards!");
            message.setFont(new Font("Calibri", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
        }
        if (card.getValue() == UnoCard.Value.Wild_Four) {
            pid = playersIds[currentPlayer];
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            JLabel message2 = new JLabel(pid + " drew 4 cards!");
            message2.setFont(new Font("Calibri", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message2);
        }
        if (card.getValue() == UnoCard.Value.Skip) {
            pid = playersIds[currentPlayer];
            JLabel message = new JLabel(pid + " is skipped!");
            message.setFont(new Font("Calibri", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            if (!gameDirection)
                currentPlayer = (currentPlayer + 1) % playersIds.length;
            else if (gameDirection) {
                currentPlayer = (currentPlayer - 1) % playersIds.length;
                if (currentPlayer == -1) {
                    currentPlayer = playersIds.length - 1;
                }
            }
            if (card.getValue() == UnoCard.Value.Reverse) {
                pid = playersIds[currentPlayer];
                JLabel message2 = new JLabel(pid + " is changing direction fo the game!");
                message.setFont(new Font("Calibri", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message2);
                gameDirection ^= true;
                if (!gameDirection)
                    currentPlayer = (currentPlayer + 2) % playersIds.length;
                else if (gameDirection) {
                    currentPlayer = (currentPlayer - 2) % playersIds.length;
                    if (currentPlayer == -1) {
                        currentPlayer = playersIds.length - 1;
                    }
                    if (currentPlayer == -2) {
                        currentPlayer = playersIds.length - 2;
                    }
                }

            }
        }
    }

    class InvalidPlayerTurnException extends Exception {
        String playerId;

        public InvalidPlayerTurnException ( String message, String pid ) {
            super(message);
            playerId = pid;
        }

        public String getPid ( ) {
            return playerId;
        }
    }

    class InvalidColorSubmissionException extends Exception {
        private UnoCard.Color expected;
        private UnoCard.Color actual;

        public InvalidColorSubmissionException ( String message, UnoCard.Color actual, UnoCard.Color expected ) {
            this.actual = actual;
            this.expected = expected;
        }
    }

    class InvalidValueSubmissionException extends Exception {
        private UnoCard.Value expected;
        private UnoCard.Value actual;

        public InvalidValueSubmissionException ( String message, UnoCard.Value actual, UnoCard.Value expected ) {
            this.actual = actual;
            this.expected = expected;
        }
    }
}
