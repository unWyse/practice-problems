/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
*/
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Integer> stk = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); i++){
            if      (s.charAt(i) == '('){
                stk.push(1);
            } 
            else if (s.charAt(i) == '[') {
                stk.push(2);
            }
            else if (s.charAt(i) == '{') {
                stk.push(3);
            }
            
            else if (s.charAt(i) == ')') {
                if (stk.empty() || stk.pop() != 1) return false;
            }
            else if (s.charAt(i) == ']') {
                if (stk.empty() || stk.pop() != 2) return false;
            }
            else if (s.charAt(i) == '}') {
                if (stk.empty() || stk.pop() != 3) return false;
            }
        }
        if(!stk.empty()) return false;
        return true;
    }
}
