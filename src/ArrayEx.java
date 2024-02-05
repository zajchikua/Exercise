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
    public static void main(String[] args){
        System.out.println(calculateSum(3, 2, 90, -0, -1));
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
