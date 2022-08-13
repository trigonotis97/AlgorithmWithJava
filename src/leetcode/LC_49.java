package leetcode;

import java.util.*;

public class LC_49 {
}
class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] charArray=str.toCharArray();
            Arrays.sort(charArray);
            String sortedString=new String(charArray);
            if(map.containsKey(sortedString)){
                List<String> stringList=map.get(sortedString);
                stringList.add(str);
                map.replace(sortedString,stringList);
            }
            else{
                List<String> stringList=new ArrayList<>();
                stringList.add(str);
                map.put(sortedString,stringList);
            }

        }

        return new ArrayList<>(map.values());
    }
}
/*
49. Group Anagrams
Medium

7085

258

Add to List

Share
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]


Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

 */