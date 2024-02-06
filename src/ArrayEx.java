public class ArrayEx {
    public static void reverseString(String s1){
        char[] stringAr = s1.toCharArray();
        //if the string even number of chars
        int len = s1.length();
        for(int i = 0; i < len/2; i++){
            swap(i, len-1-i, stringAr );
        }
        System.out.println(stringAr);
    }
    public static void swap(int index1, int index2, char[] stringAr){
        char temp;
        temp = stringAr[index1];
        stringAr[index1] = stringAr[index2];
        stringAr[index2] = temp;
    }

    public static int calculateSum(int ...a) {
        int sum = 0;
        for (int i : a){
            sum = sum + i;
        }
        return sum;
    }

    /*
    find max product of two numbers on an unsorted array.
    do not use sort
     */
    public static int maxProduct(int[] intArray){
        int maxProduct = Integer.MIN_VALUE;
        int arLen = intArray.length;
        if(intArray.length == 0){
            System.out.println("Invalid input");
            return -1;
        }
        if(intArray.length == 1){
            System.out.println("That was easy! but not very valid input");
            return intArray[0];
        }

        for(int i = 0; i < arLen -1; i++){
            for(int j =i+ 1; j < arLen; j++){
                if(intArray[i] * intArray[j] > maxProduct){
                    maxProduct = intArray[i] * intArray[j];
                }
            }
        }
        return maxProduct;
    }
    public static void main(String[] args){
        int[] exercise2 = {1, -2, -3, -5, 7};

        int[] exercise = {1, 2, 3, 5, 7};
        System.out.println(maxProduct(exercise2));
//        System.out.println(calculateSum(3, 2, 90, -0, -1));
//        System.out.println(calculateSum(new int[]{3,2,90,0, -1}));
//        reverseString("reverse_this_stringg");
//        int b = 12345678;
//        char[] strB = Integer.toString(b).toCharArray();
//        int len = strB.length;
//        for(int i = 0; i < len/2; i++){
//            swap(i, len-1-i, strB );
//        }
//        b = Integer.parseInt(new String(strB));
//        System.out.println(b);
    }
}
