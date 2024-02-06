package CollectionsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringManipulations {

    public static void main(String[] args) {
        /*
        parse text
         */
        String parseThis = "Pandas typically lead a solitary life. " +
                "They're excellent tree climbers, but they spend most of " +
                "their time feeding. They can eat for 14 hours a day, " +
                "mainly bamboo, which is 99% of their diet " +
                "(though they sometimes eat eggs or small animals too).\n" +
                "\n" +
                "Giant pandas are living proof that conservation works. " +
                "And even better, by protecting pandas we’re " +
                "also helping protect the wider environment where they live, " +
                "for all the wildlife and the people that depend on it.";
        //how many sentences? piece of text that contains a full-stop and a following
        //space
        //split by dot space sequence
        String[] text = parseThis.split("\\. ");
        System.out.println(text);
        System.out.println(text.length);
        System.out.println(text[1]);

        //count the number of words. split by spaces
        System.out.println("count the number of words. split by spaces");
        String[] words = parseThis.split(" |-|( |) |'");
        System.out.println(Arrays.asList(words));
        System.out.println("number of words in the string: " + words.length + " words.");
        System.out.println("number of characters in the text: " + parseThis.length() + " characters in the text.");



        System.out.println("#######-----------");

        /*String manipulations with STREAM
        */
        System.out.println("String manipulations with STREAM-----#####");
        String panda = "  pAnda";
        String horse = "  horSE  ";
        String butterfly = "Butterfly ";
        String cat = "CAT  ";
        String emp = "     ";

        //User String buffer
        List<String> animals = List.of(panda, horse, butterfly, cat, emp);
        animals = animals.stream()
                .map(String::trim)
                .collect(Collectors.toList());
        System.out.println(animals);
        List<String> clearAnimals = animals.stream()
                .filter(e-> !e.isEmpty())
                .toList();
        System.out.println(clearAnimals);
        List<String> toLower = clearAnimals.stream()
                .map(String::toLowerCase)
                .toList();
        System.out.println(toLower);
        List<String> toCapit = toLower.stream()
                .map(String::toLowerCase)
                .toList();
        System.out.println(toLower);
    }
}
