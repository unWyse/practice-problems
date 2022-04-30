/*
Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

Constraints:
    1 <= s.length <= 10^4
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.
*/
class Solution {
    public int lengthOfLastWord(String s) {
        // String[] words = s.split(" ",0);
        // return words[words.length-1].length();
        
        //FAST Solution
        s = s.trim();
        int i = s.length()-1;
        while (i>=0 && s.charAt(i) != ' '){
            i--;
        }
        return s.length()-1-i;
    }
}
