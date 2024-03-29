package CollectionsExercise;

import java.util.*;

public class HashmapEx2 {
    public static void printBinary(int n){
        if(n <= 0){
            System.out.println("Incorrect input." +
                    "Please enter a natural number!");
            return;
        }
        for(int i = 0; i <= n; i++){
            System.out.println(Integer.toBinaryString(i));

        }
    }
    public static void printBinaryQueue(int n)
    {
        if(n <= 0){
            System.out.println("Incorrect input." +
                    "Please enter a natural number!");
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        for(int i= 0; i <= n; i++){
            Integer current = queue.remove();
            System.out.println(current);

            queue.add(current*10);
            queue.add(current*10 + 1);
        }
        System.out.println();
    }

    /*
    matching parenthesis
     */
    public static boolean matchParenthesis(String myString)
    {
        char[] newString = myString.toCharArray();
        Stack<Character> stack = new Stack();
        Map<Character, Character> mapParenthesis = Map.of(')','(',']','[', '>','<');
        for(int i = 0; i< newString.length; i++)
        {
            char current = newString[i];
            if( mapParenthesis.containsValue(current)){
                stack.add(current);
            }
            if(mapParenthesis.containsKey(current))
            {
                if(stack.isEmpty() || stack.peek()!=mapParenthesis.get(current))
                {
                    return false;
                }
                if(stack.peek()==mapParenthesis.get(current))
                {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();

    }
    public static void main ( String[] args ) {
        //System.out.println(matchParenthesis("<my parent[]> [] )yes"));

        /*generate first N binary numbers
        //binary number consists of 1 and 0 and
        //is on the base-2 numeral system

        1->1     4-> 100    8 -> 1000
        2-> 10  5-> 101     9 -> 1001
        3-> 11  6-> 110     10 -> 1010
                7 -> 111    11 -> 1100
                            12 -> 1101
                            13 -> 1110
                            14 -> 1111


        //set up test cases
        printBinary(5);
        printBinary(-1);
        printBinary(0);*/
        //printBinaryQueue(10);

        HashMap<String, Integer> wordsNums = new HashMap<>();
        wordsNums.put("ONE", 1);
        wordsNums.put("MILLION", 1000000);
        wordsNums.put("Gamolya", -475);
        wordsNums.put("THREE", 3);
//        System.out.println(wordsNums);
//        System.out.println(wordsNums.entrySet());
//        System.out.println(wordsNums.values());
        //list values and keys
        //System.out.println(wordsNums.keySet());
        System.out.println(wordsNums.get("ONE"));
    }
}
