// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public  static int majorityElement(int[] nums) {
        int majority = 0;
        for (int i = 0; i <= nums[i]; i++) {
            int temp = nums[i];
            if (temp > majority) {
                majority = temp;
            }
        }
        return majority;
    }

            public static void main(String[] args) {
        int[] nums = {2, 2, 1, 2, 3, 1, };
                System.out.println(majorityElement(nums));
//        // Press Opt+Enter with your caret at the highlighted text to see how
//        // IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!\n");
//
//        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Ctrl+D to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Cmd+F8.
//            System.out.println("i = " + i);

    }
}