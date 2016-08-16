public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0) return 0;
        int low=0,high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            else if(target<nums[mid])
                high=mid;
            else low=mid+1;
        }
        return nums[low]>=target?low:low+1;
    }
}