package CollectionsExercise;

import java.util.Stack;

public class StackExercise {
    public static void printStack(Stack<String> stack)
    {
        if(stack.isEmpty() )
        {
            System.out.println("nothing to print");
        }
        else {
            for (String s : stack) {
                System.out.println(s);
            }
            System.out.println("The end of the Stack!");
        }
    }
    public static void main ( String[] args ) {
        Stack<String> deckOfCards = new Stack<>();
        String jackD = "Jack : Diamonds";
        String sevenH = "Seven : Hearts";
        String threeC = "Three : Clubs";

        deckOfCards.push(jackD);
        System.out.println(deckOfCards);
        deckOfCards.push(threeC);
        System.out.println(deckOfCards);
        deckOfCards.push(sevenH);
        System.out.println(deckOfCards);
        deckOfCards.peek();
        System.out.println(deckOfCards);

        System.out.println("Print a peek:\n" + deckOfCards.peek());

        printStack(deckOfCards);
        System.out.println(deckOfCards.size());
    }
}
