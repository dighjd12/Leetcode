Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

public class Solution {
    public int minDistance(String word1, String word2) {
        
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        return minDist(word1, word2, 0, 0, dp);
    }
    
    public int minDist(String word1, String word2, int idx1, int idx2, int[][] dp){
        
        if (dp[idx1][idx2] > 0) return dp[idx1][idx2];
        
        if (idx1>=word1.length()){ 
            dp[idx1][idx2] = word2.length() - idx2;
            return word2.length() - idx2;
            
        }
        if (idx2>=word2.length()){
            dp[idx1][idx2] = word1.length() - idx1;
            return word1.length() - idx1;
        } 
        
        if (word1.charAt(idx1) == word2.charAt(idx2)){
            dp[idx1][idx2] = minDist(word1, word2, idx1+1, idx2+1, dp);
            return dp[idx1][idx2];
        }
        
        int try1 = minDist(word1, word2, idx1+1, idx2, dp);
        int try2 = minDist(word1, word2, idx1+1, idx2+1, dp);
        int try3 = minDist(word1, word2, idx1, idx2+1, dp);
        
        dp[idx1][idx2] = 1+Math.min(try3, Math.min(try1, try2));
        return 1+Math.min(try3, Math.min(try1, try2));
        
    }
    
}