package CollectionsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MostRepeatedWord {

//Find the DS mostly fitted
    //find the most repeated word in the string
    //separated by either space or punctuation
    //words without punctuation or spaces
    //chars only . Capital + low = the same
    //if 2 words are repeated equal am.of time
    //whichever set comes first should come as the result
    //should be returned
    //common words should not be count.
    public static void mostRepeatedWord(String text)
    {
        String word = "";
        int number = 0;
        //parse the string by regex with spaces and punctuation
        String[] words = text.split("\\.| |-|( |) |\\t|\\n|\\r|, |; |'|\\?|\\{ |}");
        List<String> wordsList = List.of(words);
        //go through the list of strings
        wordsList = wordsList.stream()
                .map(String::trim)
                .collect(Collectors.toList());        //put the words in string - int hash if they are not in the common words list
        //keep track of 2 biggest numbers
        //create special handling of the case when 2 similar sets
        System.out.println(Arrays.asList(wordsList));
        System.out.println("The answer is " + word + ", " + number + " times.");;
    }
    public static void main ( String[] args ) {
        String testString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        String testString2 = "Penguins are aquatic, flightless birds that are highly adapted to life in the water. Their distinct tuxedo-like appearance is called countershading, a form of camouflage that helps keep them safe in the water. Penguins do have wing-bones, though they are flipper-like and extremely suited to swimming. Penguins are found almost exclusively in the southern hemisphere, where they catch their food underwater and raise their young on land.";

        String testString3 = "Students seek relief from rising prices through the purchase of used copies of textbooks, which tend to be less expensive. Most college bookstores offer used copies of textbooks at lower prices. Most bookstores will also buy used copies back from students at the end of a term if the book is going to be re-used at the school. Books that are not being re-used at the school are often purchased by an off-campus wholesaler for 0-30% of the new cost, for distribution to other bookstores where the books will be sold. Textbook companies have countered this by encouraging faculty to assign homework that must be done on the publisher's website. If a student has a new textbook, then he or she can use the pass code in the book to register on the site. If the student has purchased a used textbook, then he or she must pay money directly to the publisher in order to access the website and complete assigned homework. ";
        mostRepeatedWord(testString3);
    }
}