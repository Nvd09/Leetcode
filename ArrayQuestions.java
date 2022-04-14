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


// Question #57. Insert Interval
/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //We need to merge intervals
        /*
        1st case:
        [[1,2], [6,9]]
            [3,5]
        [[1,2],[3,5],[6,9]]
        
        2nd case: 
        [[1,3], [6,9]]
            [2,5]
        [[1,5],  [6,9]] 
        
        3rd case:
         [[1,2], [6,9]]
            [12,18]
        [[1,2][6,9][12,18]] 
        
        */
        List<int[]>output = new ArrayList<>();
        int[] toAdd = newInterval;
        for(int[] curInterval : intervals){
            // no overlap newInterval is smaller than everything
            if(toAdd[1] < curInterval[0]){
                output.add(toAdd);
                toAdd = curInterval;
            }   
            // overlap update first and second index
            else if(curInterval[1] >= toAdd[0]){
                toAdd[0] = Math.min(curInterval[0], toAdd[0]);
                toAdd[1] = Math.max(curInterval[1], toAdd[1]);
            }
            // if no overlap and isnt smaller than current just add current
            else{
                output.add(curInterval);
            }
        }
        output.add(toAdd);
       return output.toArray(new int[output.size()][2]);
    }
}
