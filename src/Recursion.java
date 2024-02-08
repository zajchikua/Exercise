public class Recursion {
    public static void printNtimes(String name,  int times){
        int counter = 0;
        if(counter == times) return;
        System.out.println(name );

        printNtimes(name, times-1);
        System.out.println( times);

    }

    public static void printNtimes1(String name,  int times){
        if(times < 0) return;
        System.out.println(name );
        System.out.println( times);

        printNtimes1(name, times-1);
    }
    public static void printNTimes(String name,  int times, int i){
        if(i > times) return;
        System.out.println(name );
        System.out.println(times);
        printNTimes(name, times - 1, 0);
        System.out.println( i);
    }

    public static int factorial(int number){
        if(number <= 1) return 1;
        return number * factorial(  number- 1);
    }
    /*
    Exercise 1: Sum of Natural Numbers
Write a recursive Java method to calculate the sum of the first n natural numbers.
     */

    public static int naturalSum(int n)
    {
        if(n == 0){
            return 0;
        }
        return n + naturalSum(n-1);

    }
    public static int fibonacci(int n){
        if(n<=1){
            return n;
        }
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }

    public static String reverseString(String str){
        if(str.isEmpty()){
            return str;
        }
        else
            return reverseString(str.substring(0));
    }
    public static void main(String[] args) {
       // printNtimes("Miro & Evangelina", 5);
        //printNTimes("Miro & Evangelina", 5, 0);
        //printNtimes1("Miro", 5);
        //System.out.println(factorial(5));
        //System.out.println(naturalSum(5));
//        System.out.println(fibonacci(7));
        System.out.println(reverseString("asrting"));
    }
}
