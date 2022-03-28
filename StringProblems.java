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
