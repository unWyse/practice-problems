/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Constraints:
    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4
*/

///BRUTE FORCE SOLUTION O(n^2) - try again for O(n) or O(log n)
class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int maxSum = nums[0];
        int sum;
        for (int i = 0; i < nums.length; i++){
            sum = nums[i];
            for (int j = i+1; j < nums.length; j++){
                if (sum > maxSum) maxSum = sum;
                sum += nums[j]; 
            }
            if (sum > maxSum) maxSum = sum;
            if (maxSum > result) result = maxSum;
        }
        return result;
    }
}
