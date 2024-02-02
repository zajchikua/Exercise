import java.sql.Array;
import java.util.*;

public class Exercise {
    /*
    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     */

    /*
    Find an element that appears more than others.
     */
    public static int majorityElementBruteForce(int[] nums) {
        //Brute force: scan through all the elements each time without sorting
        //Complexity: O(N*2)
        int majority = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            majority = nums[0];
            int counter = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    nums[j] = majority;
                    counter++;
                }
                if (counter > nums.length / 2) {
                    return majority;
                }
            }
        }
        return majority;
    }
    public static int majorityElementMap(int[] nums) {
            //Map the element into a hash map and add a counter
        HashMap<Integer, Integer> numbers = new HashMap<>();
        int majority = 0;
        for (int number : nums) {
            if(numbers.containsKey(number)){
                numbers.put(number, +1);
            }
            else numbers.put(number, 1);
        }

        //Find the key mapped to the highest value
        Integer maxValue = Collections.max(numbers.values());
        for(Map.Entry<Integer, Integer> entry : numbers.entrySet()){
            if(entry.getValue().equals(maxValue)){
                majority = entry.getKey();
            }
        }

        return majority;
    }

    public static int majorityElementMapNoBuiltIn(int[] nums) {
        //Map the element into a hash map and add a counter
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int number : nums) {
            if(numbers.containsKey(number)){
                numbers.put(number, +1);
            }
            else numbers.put(number, 1);
        }

        //Find the key mapped to the highest value without built-in functions
        int maxValue = Integer.MIN_VALUE;
        int majority = -1;
        for(Map.Entry<Integer, Integer> entry : numbers.entrySet()){
            if(entry.getValue() > maxValue){
                maxValue = entry.getValue();
                majority = entry.getKey();
            }
        }

        return majority;
    }

    public static int maj(int[] nums){
        int count = 0;
        int n = nums.length;
        int maxValue = Integer.MIN_VALUE;
        int maj = -1;
        HashMap<Integer, Integer> numMap = new HashMap<>();
        //iterate through all the elems
        for(int i = 0; i < n; i++){
            if(numMap.containsKey(nums[i])){
                numMap.put(nums[i], +1);
            }
            else
                numMap.put(nums[i], 1);
        }
        //get the max value
        for(Map.Entry<Integer, Integer> entry : numMap.entrySet())
            {
                if(entry.getValue() > maxValue)
                    {
                        maxValue = entry.getValue();
                        maj = entry.getKey();
                        if(maxValue > n/2)
                        {
                            return maj;
                        }
                    }
        }
        return maj;
    }

    public static int majWithCounter(int[]nums)
    {
        int l = nums.length;
        int maj = 0;
        int counter = 0;
        for(int i = 0; i < l; i++)
        {
            if(counter == 0){
                counter = 1;
                maj = nums[i];
            }
            else if(maj == nums[i])
                counter += 1;
            else
                counter--;
        }
        return maj;
    }

    public static int majorityElementAlgo(int[] v)
    {
        int maj = -1;
        int counter = 0;
//find the element by algo Moore's voting
        for(int i = 0; i < v.length; i++){
            if(counter == 0)
            {maj = v[i] ;
            counter = 1;
            }
            else if(v[i] == maj)
            {
                counter++;
            }
            else
                counter--;
        }

        //check if the element is really a majority
        int checkCounter = 0;
        for(int i = 0; i < v.length; i++){
            if(v[i] == maj) checkCounter++;
        }
        if(checkCounter > (v.length/2)){
            return maj;
        }
        else {
            System.out.println("Incorrect array with incorrect input");
            return -1;}
    }

    public static void printTree(int n){
        //print a tree with base of n symbols
        if( n < 3)
        {
            System.out.println("Invalid params");
            return ;
        }
        String empty = " ";
        //outer loop for rows
        for (int i = 0; i < n; i++){
            //number of columns
            for (int j = 0; j < n - 1 - i; j++)
            {
                System.out.print(" ");
            }

            for(int k=0;k< 2*i+1;k++){

                System.out.print("*");
            }
  System.out.println();
        }
    }

    public static int[] searchPattern(String text, String pattern)
    {

        int[] res = new int[text.length()];
        int l = text.length();
        int m = pattern.length();
        int resIndex = 0;
        //outer loop, based on first letter match.
        for(int i = 0; i < l; i++){
            System.out.println(text.charAt(i));
            if(text.charAt(i) == pattern.charAt(0))
            {
                int currentIndex = i;
                res[resIndex] = currentIndex;//if(i-m > 0) {
                    for (int j = 1; j < m; j++) {
                        if(text.charAt(i+j) == pattern.charAt(j) && (i + j) < l)
                        {
                            System.out.println(j);
                            i++;
                        }
                        if(text.charAt(i+j) != pattern.charAt(j)){
                            currentIndex = i+j;
                            j = m;
                        }
                        i = currentIndex;
                    }
                    resIndex += 1;
                //}
            }
        }
        //inner loop, if the 1st letter matches, go the 2nd and 3rd
        return  res;
    }

    public static void main(String[] args) {
        System.out.println(searchPattern("cxcxxxyxyzghfjxyzweriuytpoyxyz", "xyz"));
 //       int[] nums = {2, 2, 1, 2, 3, 1,0, 10, 5, 4, 4, 4, 4};
 //       printTree(3);
//        System.out.println(majorityElementBruteForce(nums));
//        System.out.println(majorityElementMap(nums));
//        System.out.println(majorityElementMapNoBuiltIn(nums));
//        System.out.println("without looking "+ maj(nums));
//        System.out.println("majWithCounter algo "+ majWithCounter(nums));
 //       System.out.println("majWithCounter algo "+ majorityElementAlgo(nums));
    }
}
