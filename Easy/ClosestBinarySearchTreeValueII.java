
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        List<Integer> res = new ArrayList<Integer>();
        if (k==0) return res;
        
        Integer exact = findExact(root, target);
        
        if (exact != null){
            res.add(exact);
            k--;
        }
        
        Integer left = findValLessThan(root, target);
        Integer right = findValGreaterThan(root, target);
        while (k>0){
            
            k--;
            if (left == null){
                res.add(right);
                right = findValGreaterThan(root, right);
                continue;
            }
            
            if (right == null){
                res.add(left);
                left = findValLessThan(root, left);
                continue;
            }
            
            double diffLeft = target-left;
            double diffRight = right-target;
            
            if (diffLeft < diffRight){
                res.add(left);
                left = findValLessThan(root, left);
            }else {
                res.add(right);
                right = findValGreaterThan(root, right);
            }
            
            
        }
        
        return res;
    }
    
    public Integer findExact(TreeNode root, double target){
        
        if (root == null) return null;
        
        Integer c = null;
        if (root.val == target){
            
            return root.val;
            
        }
        
        if (root.val > target){
            //recurse on left
            return findExact(root.left, target);
            
        }else {
            return findExact(root.right, target);
        }
        
    }
    
    public Integer findValLessThan(TreeNode root, double target){
        
        if (root == null) return null;
        
        Integer c = null;
        if (root.val >= target){
            //recurse on left
            c = findValLessThan(root.left, target);
            return c;
        }
            
        c = findValLessThan(root.right, target);
        if (c == null) return root.val;
        if (c > root.val) return c;
        return root.val;
         
    }
    
    public Integer findValGreaterThan(TreeNode root, double target){
        
        if (root == null) return null;
        
        Integer c = null;
        if (root.val <= target){
            //recurse on right
            c = findValGreaterThan(root.right, target);
            return c;
        }
            
        c = findValGreaterThan(root.left, target);
        if (c == null) return root.val;
        if (c < root.val) return c;
        return root.val;
         
    }
    
}