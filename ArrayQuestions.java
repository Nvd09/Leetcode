// Question #53

// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
// A subarray is a contiguous part of an array.

class Solution {
    public int maxSubArray(int[] nums) {
        /* 
        Kadane's algorithm -> Do I wanna add the current num to the sum or Do I wanna start over the current sum
        if Adding the sum is greater than the current number then add
        else start over
        */
        
        int max = nums[0];
        int curSum = nums[0];
        for(int end = 1; end<nums.length; end++){
            curSum = Math.max(curSum + nums[end], nums[end]); 
            max = Math.max(max, curSum);
        }
        return max;
    }
}



