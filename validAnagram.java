/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or 
phrase, typically using all the original letters exactly once.
 
Constraints:
    1 <= s.length, t.length <= 5 * 10^4
    s and t consist of lowercase English letters.
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        Map<Character,Integer> sMap = new HashMap <Character,Integer>();
        Map<Character,Integer> tMap = new HashMap <Character,Integer>();
        char c = '~';
        
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(sMap.containsKey(s.charAt(i))) {
                sMap.replace(c, sMap.get(c)+1);
            }
            else {
                sMap.put(s.charAt(i), 1);
            }
        }
        
        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            if(tMap.containsKey(t.charAt(i))) {
                tMap.replace(c, tMap.get(c)+1);
            }
            else {
                tMap.put(t.charAt(i), 1);
            }
        }
        for (Character key : sMap.keySet()) {
            if(!tMap.containsKey(key) || sMap.get(key).intValue() != tMap.get(key).intValue()) return false;
        }
        
        return true;
    }
}
