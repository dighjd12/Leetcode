
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.



public class Solution {
    public boolean isScramble(String s1, String s2) {
        
        if (s1 == null || s2 == null) return false;
        
        if (s1.length() != s2.length()) return false;
        if (s1.length()==1 && s1.equals(s2)){
            return true;
        }
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(!new String(arr1).equals(new String(arr2))){
            return false;
        }
        
        for (int i=1; i<=s1.length()-1; i++){
            
            String left = s1.substring(0,i);
            String right = s1.substring(i);
            String lefts2 = s2.substring(0,i);
            String rights2 = s2.substring(i);
            
            //this children not swapped?
            if (isScramble(left, lefts2) && isScramble(right, rights2)){
                return true;
            }
            
            //children swapped?
            String leftt = s2.substring(0, right.length());
            String rightt = s2.substring(right.length());
            
            if (isScramble(right, leftt) && isScramble(left, rightt)){
                return true;
            }
            
        }
        return false;
        
    }
}