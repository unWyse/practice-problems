/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors.
'#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Constraints:
    1 <= s.length, t.length <= 200
    s and t only contain lowercase letters and '#' characters.
*/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return bsc(s).equals(bsc(t));
    }
    
    private String bsc(String s) {
        int i = s.indexOf('#');
        if (i == -1) return s;
        else if (i == 0) return bsc(s.substring(1, s.length()));
        else return bsc(
            s.substring(0, i-1) +
            s.substring(i+1, s.length())
        );
    }
}
