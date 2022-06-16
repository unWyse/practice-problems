/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.

Constraints:
    1 <= arr.length <= 1000
    1 <= arr[i] <= 1000
    1 <= k <= 1000
    arr[i] < arr[j] for 1 <= i < j <= arr.length
*/
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int expected = 0;
        int countMissing = 0;
        int index = 0;
        while (countMissing < k) {
            expected++;
            if(index < arr.length && arr[index] == expected) {
                index++;
            }
            else {
                countMissing++;
            }
        }
        return expected;
    }
}
