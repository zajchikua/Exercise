package CollectionsExercise;

import java.util.*;

public class LongestSubstring {
    /**
     *  Given a string s, find the length of the longest
     * substring
     *  without repeating characters.
    *
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public static String longestSubOptima(String stringToWorkOn)
    {
        String returnString = "";
        Map<Character, Integer> visited = new HashMap<>();
        for (int start = 0, end = 0; end < stringToWorkOn.length(); end++)
        {
            char current = stringToWorkOn.charAt(start);

            if (visited.containsKey(current))
            {
                start = Math.max(visited.get(current)+1, start);
            }
            if (returnString.length() < end - start + 1)
            {
                returnString = stringToWorkOn.substring(start, end + 1);
            }
            visited.put(current, end);
        }
        return returnString;
    }
    public static String longestSubBruteForce(String myString)
    {
        char[] myArr = myString.toCharArray();

        int length = -1;
        int max = -1;
        ///add prinout of the longest string
        String longest = "";
        if(myString.isEmpty())
        {return "-1";}
        else if(myString.length() ==1)
        {return "1";}
        // examine each substring for unique chars
        for(int start = 0; start < myArr.length; start++)
        {
            Set<Character> chars = new HashSet<>();
            int end = start;
            for(; end < myArr.length; end++)
            {
                char current = myArr[end];
                if(chars.contains(current)){
                    break;
                } else chars.add(current);

            }
            if(chars.size() < end - start + 1)
            {
                length = chars.size();

            }
            if (length > max)
            {
                max = length;
                longest = myString.substring(start, end);
            }
        }
        return longest + " " + max;
    }

    public static void main ( String[] args ) {
        System.out.println(longestSubOptima("CODINGISAWESOME"));
        //System.out.println(longestSubBruteForce("CODINGISAWESOME"));
    }
}
