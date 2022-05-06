/*
You have a set of integers s, which originally contains all the numbers from 1 to n.
Unfortunately, due to some error, one of the numbers in s got duplicated to another 
number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the 
error.

Find the number that occurs twice and the number that is missing and return them in the 
form of an array.

Constraints:
    2 <= nums.length <= 10^4
    1 <= nums[i] <= 10^4
*/
class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        System.out.print(Arrays.toString(nums));
        int duplicate = 0;
        int missing = 1;
        for (int i = 0; i < nums.length-1; i++){
            if(nums[i]==nums[i+1]) duplicate = nums[i];
            if(nums[i]==missing) missing++;            
        }
        if(nums[nums.length-1]==missing) missing++;
        return new int[] {duplicate, missing};       
    }
}
