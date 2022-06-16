/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Constraints:
    1 <= numRows <= 30
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        ans.add(tmp);
        
        while(ans.size() < numRows) {
            ans.add(nextLine(ans.get(ans.size()-1)));
        }
        
        return ans;
    }
    
    private List<Integer> nextLine(List<Integer> priorLine) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        
        int op1; int op2;
        int i = 0;
        while(i < priorLine.size()-1) {
            op1 = priorLine.get(i);
            op2 = priorLine.get(i+1);
            result.add(op1+op2);
            i++;
        }
        
        result.add(1);
        return result;
    }
}
