/*
Given a string s, return true if the s can be palindrome after deleting AT MOST one character from it.

Constraints:
    1 <= s.length <= 10^5
    s consists of lowercase English letters.
*/

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i <= (s.length()/2)) {
            if (s.charAt(i) != s.charAt(j)) {
                StringBuilder a = new StringBuilder(s).deleteCharAt(i);
                StringBuilder b = new StringBuilder(s).deleteCharAt(j);

                return a.toString().equals(a.reverse().toString()) 
                    || b.toString().equals(b.reverse().toString());
            }
            i++;
            j--;
        }
        return true;
    }
}
