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
