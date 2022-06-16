/*
You are given a license key represented as a string s that consists of only alphanumeric 
characters and dashes. The string is separated into n + 1 groups by n dashes. You are 
also given an integer k.

We want to reformat the string s such that each group contains exactly k characters, 
except for the first group, which could be shorter than k but still must contain at least 
one character. Furthermore, there must be a dash inserted between two groups, and you 
should convert all lowercase letters to uppercase.

Return the reformatted license key.

Constraints:
    1 <= s.length <= 10^5
    s consists of English letters, digits, and dashes '-'.
    1 <= k <= 10^4
*/
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String result = "";
        s = s.replace("-","");
        if (s.length() <= k) return s.toUpperCase();
        
        //first n<=k characters
        int offset = s.length() % k;
        if (offset == 0) offset = k;
        
        result = s.substring(0,offset);
        
        //groups of k 
        while (offset < s.length()) {
            result += "-" + s.substring(offset,offset+k);
            offset += k;
        }
        
        return result.toUpperCase();
    }
}
