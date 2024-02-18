package CollectionsExercise;

import java.util.Arrays;

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
        int maxProduct = 1;
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
            for(int j = i+ 1; j < arLen; j++){
                if(intArray[i] * intArray[j] > maxProduct){
                    maxProduct = intArray[i] * intArray[j];
                }
            }
        }
        return maxProduct;
    }
    public static int maxProduct2(int[] intArray)
    {
        if(intArray.length < 2){
            System.out.println("Invalid input");
        }
        Arrays.sort(intArray);
        int firstTwo = intArray[1]*intArray[0];
        int lastTwo = intArray[intArray.length-1]*intArray[intArray.length-2];
        if(firstTwo < lastTwo){
            return lastTwo;
        }
        else
            return firstTwo;
    }

    //This is an algo when we are lineraly find 2 mins and 2 max numbers by trakcing them.
    // then we are finding the product
    public static int maxProduct3(int [] myArr)
    {
        int max1 = myArr[0];
        int max2 = Integer.MIN_VALUE;
        int min1 = myArr[0];
        int min2 = Integer.MAX_VALUE;

        for(int i = 0; i < myArr.length; i++) {
            if (myArr[i] < min1) {
                min2 = min1;
                min1 = myArr[i];
            } else if (myArr[i] < min2) {
                min2 = myArr[i];
            } else if (myArr[i] > max1) {
                max2 = max1;
                max1 = myArr[i];

            } else if (myArr[i] > max2) {
                max2 = myArr[i];
            }
        }
        int maxProd = max1 * max2;
        int minProd = min1 * min2;
        if(minProd > maxProd){
            return minProd;
        } else return  maxProd;
    }

        public static void main(String[] args){
        int[] exercise2 = {1, -2, -3, -5, -8, 0,  8, 7};


        int[] exercise = {1, 2, 3, 5, 7};
          System.out.println(maxProduct3(exercise2));

            //System.out.println(maxProduct2(exercise2));
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
