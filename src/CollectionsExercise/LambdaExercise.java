package CollectionsExercise;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExercise {
    public static void main ( String[] args ) {
        Predicate<String> largerThan5 = s -> s.length() > 5;
        boolean result = largerThan5.test("hello");
        System.out.println(result);

        Consumer<String> toUpper = s -> System.out.println(s.toUpperCase());
        toUpper.accept("How can it be so easy?");

    }
}
