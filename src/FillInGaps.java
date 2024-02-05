import java.util.Scanner;

public class FillInGaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's create an interactive game here," +
                "/nEnter your favorite color:");
        String color = scanner.next();
        System.out.println("Enter a season:");
        String season = scanner.next();
        System.out.println("Enter a whole number:");
        int number = scanner.nextInt();
        scanner.close();
        System.out.println("On a nice " + season + " day I tend to drink "
        + number + " cups of hot coffee! :) And of course out of my "+
                color + " cup...");
    }
}
