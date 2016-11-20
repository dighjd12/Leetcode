

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.

Complexity: O(n^2)

public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
 
    if(nums == null || nums.length<3)
        return result;
 
    Arrays.sort(nums);
 
    for(int i=0; i<nums.length-2; i++){
        if(i==0 || nums[i] > nums[i-1]){

        	// choose ith element to be included
            int j=i+1;
            int k=nums.length-1;
 
 			// j = start of the rest of the array and k is the end of the array
 			// traverse inwards to find the correct sum.
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
 
                    j++;
                    k--;
 
                    //handle duplicate here
                    while(j<k && nums[j]==nums[j-1])
                        j++;
                    while(j<k && nums[k]==nums[k+1])
                        k--;
 
                }else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else{
                    k--;
                }
            }
        }
 
    }
 
    return result;
}
