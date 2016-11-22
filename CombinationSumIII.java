Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]


public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        
        search(res, curr, 1, k, n);
        return res;
    }
    
    public void search(List<List<Integer>> res, List<Integer> curr, int i, int k, int n){
        
        if (k == 0 && n==0){
            res.add(new ArrayList<Integer>(curr));
            return;
        } 
        if (k==0) return;
        if (n<=0) return;
        if (i > 9) return;
        
        curr.add(i);
        search(res, curr, i+1, k-1, n-i);
        curr.remove(new Integer(i));
        search(res, curr, i+1, k, n);
        
    }
    
}