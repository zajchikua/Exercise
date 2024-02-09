package CollectionsExercise.LinkedListExercise;

import java.util.LinkedList;

public class linkedListEx {
    public static void main(String[] args) {
        //create a Linked List
        LinkedList<String> people = new LinkedList();
        people.add("Sveta");
        System.out.println(people.contains("Sve"));
        System.out.println(people.get(0));
        System.out.println(people.indexOf("Sveta"));
        people.addFirst("Zhenya");
        System.out.println(people.indexOf("Zhenya"));
        System.out.println(people.indexOf("Sveta"));
        System.out.println(people.size());
        System.out.println(people.add(""));
        System.out.println(people.size());
        people.add(10, "");
        System.out.println(people.size());
        System.out.println(people.get(7));
    }

}
