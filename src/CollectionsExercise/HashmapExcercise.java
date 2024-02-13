package CollectionsExercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//I need to compare 2 strings if the characters
// in these strings are the same, order doesn't matter.

public class HashmapExcercise {

    public static String compareStrings(String s1, String s2){
        String answer = "";
        HashMap<Character, Integer>string1 = new HashMap<>();
        if(s2.length() != s1.length() || s1.isEmpty())
            return "No";

        for(int i = 0; i < s1.length(); i++)
        {
            if(string1.containsKey(s1.charAt(i))){
                //int val = string1.get().
                string1.put(s1.charAt(i), string1.get(s1.charAt(i))+1);
            }
            string1.put(s1.charAt(i), 1);
        }

        int count = s1.length();
        for(int j = 0; j < s2.length(); j++){
            char charac = s2.charAt(j);
            if(string1.containsKey(charac) && string1.get(charac) != 0){
                string1.put(charac,  string1.get(charac)-1);
                if(string1.get(charac) == 0){
                    count -=1;
                }
            }

            else if(string1.containsKey(charac) && string1.get(charac) == 0 )
            {
                answer = "No";
                break;
            }
            if(!string1.containsKey(charac)){
                answer = "No";
                break;
            }
            if(j == s2.length()-1 || count == 0){
                answer = "Yes";
            }
            else
                answer = "No";
        }

        return answer;
    }
    /*

Count Occurrences:

Write a program that takes a String as input and counts the occurrences
of each character. Store the counts in a HashMap.
*/
    public static void countOccurrences(String string1) {
        char[] strArr = string1.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i=0; i < strArr.length; i++){
            if(hashMap.containsKey(strArr[i])){
                hashMap.put(strArr[i], hashMap.get(strArr[i])+1);
            }
            else
                hashMap.put(strArr[i], 1);

        }
        System.out.println(hashMap);
    }
/*
Word Frequency:

Given a list of words, create a program that calculates the frequency of each word using a HashMap.

*/
public static void wordFreq(List<String> listWords) {

    HashMap<String, Integer> hashMap = new HashMap<>();
    for(int i=0; i < listWords.size(); i++){
        if(hashMap.containsKey(listWords.get(i))){
            hashMap.put(listWords.get(i), hashMap.get(listWords.get(i))+1);
        }
        else
            hashMap.put(listWords.get(i), 1);
    }
    System.out.println(hashMap);
}
/*Merge Maps:

Write a method to merge two HashMaps. If there are common keys, sum their values.

public static void mergeMaps(HashMap<String, Integer>hm1, HashMap<String, Integer> hm2){
    if(hm1.size() < hm2.size()){
        //inner loop for hm1
        for(int i = 0; i < hm1.size(); i++){
            for(int j = 0; j < hm2.size(); j++){
                if(hm1.(i) == hm2.get(j)){
                    hm1.put(hm1.get(i), hm1.get(i)+1);
                }
                else hm1.put(hm1.get(i), 1);

            }

        }
    }
    System.out.println(hm1);
}
/*Remove Duplicates:
Create a program that removes duplicate elements from an ArrayList using a HashMap.*/
   public static void removeDupes(List<String> myArr){
       Map<String, Integer> stringOccur = new HashMap<>();
       for(String s : myArr)
       {
           if(stringOccur.containsKey(s)){
               stringOccur.put(s, stringOccur.get(s) + 1);
           }
           else
               stringOccur.put(s, stringOccur.getOrDefault(s, 0)+1);
       }
       System.out.println(stringOccur.keySet());
   }
/*Anagrams Grouping:

Given an array of strings, group anagrams together using a HashMap.
Student Grades:

Create a program that stores student names and their corresponding grades in a HashMap. Allow the user to add, remove, or update grades.
Palindrome Check:

Write a function that checks whether a given string is a palindrome using a HashMap to store character frequencies.
First Non-Repeating Character:

Find the first non-repeating character in a string using a HashMap.
Word Pattern Matching:

Given a pattern and a string, determine if the string follows the same pattern. Use a HashMap to store the mapping.
Longest Subarray with Equal Number of Zeros and Ones:

Find the length of the longest subarray with an equal number of 0s and 1s using a HashMap.
     */

    public static void main(String[] args) {
        System.out.println(compareStrings("urgqwerttyyuiophiv", "urguipoiuytrewqb"));
        countOccurrences("can't be that just a coincidence");
        List<String> wordList = new ArrayList<>();

        wordList.add("apple");
        wordList.add("banana");
        wordList.add("orange");
        wordList.add("orange");
        removeDupes(wordList);
       // System.out.println(wordList);
//        wordFreq(wordList);
//        HashMap<String, Integer> a = new HashMap<>();
//        a.put("apple", 1);
//        a.put("grape", 0);
//        for(Map.Entry<String, Integer> Entry: a.entrySet()){
//            System.out.println("This is key " + Entry.getKey());
//            System.out.println("This is value of the key " + Entry.getValue());
//        }

    }
//    public static void printString(String s1){
//
//        for(int i = 0; i < s1.length(); i++){
//            System.out.println(s1.charAt(i));
//        }
//    }
//    public static void main(String[] args) {
//        printString("urgh");
//    }
    }
