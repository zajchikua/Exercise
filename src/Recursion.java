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

    public static void factorial(int number){
        if(number < 1) return;
        System.out.println(number);
        factorial( number * ( number- 1));
    }
    public static void main(String[] args) {
        printNtimes("Miro & Evangelina", 5);
        //printNTimes("Miro & Evangelina", 5, 0);
printNtimes1("Miro", 5);
factorial(5);
    }
}
