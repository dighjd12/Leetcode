Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

public class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length - 1;
        for (int i=0; i<nums.length; i++){
            
            int c = nums[i];
            int idx = c-1;
            while (idx != i || nums[idx] != c){
                
                if (nums[idx] == c){
                    //duplicate 
                    return c;
                }
                
                //swap
                int temp = nums[idx];
                nums[idx] = c;
                nums[i] = temp;
                
                c = temp;
                idx = c-1;
                
            }
            
            
        }
        
        return -1;
        
    }
}