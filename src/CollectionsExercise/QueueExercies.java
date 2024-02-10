package CollectionsExercise;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExercies {
    public static void main ( String[] args ) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Harish");
        queue.add("Gregory");
        queue.add("Kathy");
        queue.add("Blare");
        System.out.println(
                queue
        );
        for(String person : queue){
            System.out.println(person);
        }
        System.out.println("Print out queue peek "+ queue.peek());

        System.out.println("Print out queue poll "+ queue.poll());
    }
}
