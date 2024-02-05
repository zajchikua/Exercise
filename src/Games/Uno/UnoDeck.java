package Games.Uno;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/*
A UNO deck consists of 108 cards, of which there are 76 Number cards,
24 Action cards and 8 Wild cards. UNO cards have four color "suits",
which are red, yellow, blue and green.
one 0 card, 2 1 cards, 2s, 3s, 4s, 5s, 6s, 7s, 8s, 9s, 2 draw 2, 2 skips, 2 rev
 */
public class UnoDeck {
    private UnoCard[] cards;
    private int cardsInDeck;
    public UnoDeck()
    {
        cards = new UnoCard[108];
    }
    //сreate cards properties
    public void reset()
    {
        UnoCard.Color[] colors = UnoCard.Color.values();
        UnoCard.Value[] values = UnoCard.Value.values();
        UnoCard.Value[] specValues = new UnoCard.Value[]{UnoCard.Value.Skip, UnoCard.Value.Reverse, UnoCard.Value.DrawTwo};

        cardsInDeck = 0;
        for(int i = 0; i < colors.length-1; i++)
        {
            UnoCard.Color color = colors[i];
            cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(0));
            for(int j = 0; j < 10; j++)
            {
                UnoCard.Value value = values[j];
                //need 2 cards of the same value
                cards[cardsInDeck++] = new UnoCard(color, value);
                cards[cardsInDeck++] = new UnoCard(color, value);
            }

            //create wild and specific cards x2
            for(UnoCard.Value sv : specValues)
            {
                cards[cardsInDeck++] = new UnoCard(color, sv);
                cards[cardsInDeck++] = new UnoCard(color, sv);
            }
        }
        //create wild cards x4
        for(int k = 0; k < 4; k++)
        {
            cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Wild, UnoCard.Value.Wild);
            cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Wild, UnoCard.Value.Wild_Four);

        }
    }

    public void replaceDeckWith(ArrayList<UnoCard> cards)
    {
        this.cards = cards.toArray(new UnoCard[cards.size()]);
        this.cardsInDeck = this.cards.length;
    }

    /**
     *
     * @return true if no cards on the deck
     */
    public boolean isEmpty()
    {
        return cardsInDeck == 0;
    }

    public void shuffle()
    {
        int n = cards.length;
        Random randon = new Random();

        //get a randon index of the array past the currnt index
        //the aruqment is an exlusive value
        //wsap the random elemtn with the present
        for(int l = 0; l < cards.length; l++)
        {
            int rvalue = l + randon.nextInt(n-l);
            UnoCard rCard = cards[rvalue];
            cards[rvalue] = cards[l];
            cards[l] = rCard;
        }
    }

    public UnoCard drawCard() throws IllegalArgumentException
    {
        if(isEmpty())
        {throw new IllegalArgumentException("Cannot draw a card since there are no cards in the deck");}
        return  cards[--cardsInDeck];
    }

    public ImageIcon drawCardImage() throws IllegalArgumentException
    {
        if(isEmpty())
        {throw new IllegalArgumentException("Cannot draw a card since there are no cards in the deck");}
        return new ImageIcon(cards[--cardsInDeck].toString() + ".png");

    }

    public UnoCard[] drawCard(int n) throws IllegalArgumentException
    {
        if(isEmpty())
        {throw new IllegalArgumentException("Cannot draw a card since there are no cards in the deck");}

        if(n < 0 )
        {throw new IllegalArgumentException("Must draw positive cards but tried to draw" +
               n +  " cards.");}

        if(n > cardsInDeck )
        {throw new IllegalArgumentException("Cannot draw " +
                n +  " cards since there are only " + cardsInDeck + " cards on the deck.");}

        UnoCard[] ret = new UnoCard[n];
        for (int m = 0; m < n; m++)
        {ret[m] = cards[--cardsInDeck];}
        return ret;
    }
}

