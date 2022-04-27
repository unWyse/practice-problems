/*
Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward.
For example, 121 is a palindrome while 123 is not.
*/

class Solution {
    public boolean isPalindrome(int x) {
        if (x==0) return true;
        if (x<0 || x%10==0) return false;
        
        StringBuilder a=new StringBuilder(Integer.toString(x));
        
        return a.toString().equals(a.reverse().toString());
    }
}
