/*
Quetion # 54: Length of Last Word

Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.
*/
class Solution {
    public int lengthOfLastWord(String s) {
        //Iterate over the string backwards if we hit a empty space we return the length;
        int length = 0;
        for(int i=s.length()-1; i>=0; i--){
            char curChar = s.charAt(i);
            if(curChar !=' ' ){
                length++;
            }
            else if(length > 0 && curChar==' '){
                break;
            }
        }
        return length;
    }
}

/*
Question #3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        String s = "abcabcbb" 
        output = 3 because "abc" is the longest
        */
        int a_pointer = 0;
        int b_pointer = 0;
        int maxLength = 0;
        Set<Character> freqSet = new HashSet<Character>();
        while(b_pointer<s.length()){
            if(!freqSet.contains(s.charAt(b_pointer))){
                freqSet.add(s.charAt(b_pointer));
                b_pointer++;
                //Since hash_set has all the unique characters, the size would mean the substring size
                maxLength = Math.max(maxLength, freqSet.size());
            }
            else{
                freqSet.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return maxLength;
    }
}

/*
Question# 424 You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. 
You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
*/

class Solution {
    public int characterReplacement(String s, int k) {
        //Two ways to solve this problem either with Array or with HashMap
      /*  
         Use the dynamic sliding window algorithm
        Map<Character, Integer> freqMap = new HashMap<>();
        int begin = 0;
        int charReplacement = 0;
        int maxRepeatingChar = 0;
        
        for(int end=0; end<s.length(); end++){
            char curChar = s.charAt(end);
            freqMap.put(curChar, freqMap.getOrDefault(curChar, 0)+1);
            maxRepeatingChar = Math.max(maxRepeatingChar, freqMap.get(curChar));
            //Check window length - maxRepating because AABAB - AAA > 1
            if(end - begin + 1 - maxRepeatingChar > k ){
                //Need to remove the first char of the string from the map
                char firstChar = s.charAt(begin);
                freqMap.put(firstChar, freqMap.get(firstChar)-1);
                begin++;
            }
            charReplacement = Math.max(charReplacement, end-begin+1);
        }
        return charReplacement;
        */
        
        //Create a dynamic sliding window
        //we can use int array of 26 to keep track of the characterss
        //find the max repeating char on the current char
        // check if window length- maxrepating char > k
        // We reduce the window
        int maxLength = 0;
        int maxRepeatingChar = 0;
        int start = 0;
        int [] freq = new int[26];
        for(int end = 0; end<s.length(); end++){
            char curChar = s.charAt(end);
            freq[curChar-'A']++;  //Saving the number of times each char shows up
            maxRepeatingChar = Math.max(maxRepeatingChar, freq[curChar-'A']);
            if(end-start+1 - maxRepeatingChar > k){
                char startChar = s.charAt(start);
                freq[startChar - 'A']--;
                start++;
            }
            maxLength= Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }
}

/*
Question #242. Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for(int i=0; i<length; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) +1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) -1);
        }
        for(char c : map.keySet()){
            if(map.get(c) != 0){
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int [] freq = new int[26];
        for(int i=0; i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length();i++){
            freq[t.charAt(i)-'a']--;
        }
        for(int i: freq){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
