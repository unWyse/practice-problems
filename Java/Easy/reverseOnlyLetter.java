/*
Given a string s, reverse the string according to the following rules:

    All the characters that are not English letters remain in the same position.
    All the English letters (lowercase or uppercase) should be reversed.

Return s after reversing it.

Constraints:
    1 <= s.length <= 100
    s consists of characters with ASCII values in the range [33, 122].
    s does not contain '\"' or '\\'.
*/
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] c = s.toCharArray();
        
        int i = 0;
        int j = c.length-1;
        char tmp = '~';
        while(i < j) {
            if(isLetter(c[i])) {
                if(isLetter(c[j])) {
                    tmp = c[i];
                    c[i] = c[j];
                    c[j] = tmp;
                    i++;
                    j--;
                } 
                else {
                    j--;
                }
            }
            else {
                i++;
            }
        }
        return new String(c);
    }
    
    private boolean isLetter(char a){
        return 65 <= a && a <= 90 || 97 <= a && a <= 122;
    }
}
