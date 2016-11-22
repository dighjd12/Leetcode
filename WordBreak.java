Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        
        int[][] dp = new int[s.length()+1][s.length()+1];
        return helper(s, wordDict, 0, dp);
    }
    
    public boolean helper(String s, Set<String> wordDict, int currI, int[][] dp){
        
        if (dp[currI][s.length()] == 1) return true;
        if (dp[currI][s.length()] == 2) return false;
        if (wordDict.contains(s.substring(currI))){
            dp[currI][s.length()] = 1;
            return true;
        }
        
        for (int j=currI+1; j<s.length(); j++){
            if (wordDict.contains(s.substring(currI, j))){
                dp[currI][j] = 1;
                if (helper(s, wordDict, j, dp)) return true;
            }
        }
        dp[currI][s.length()] = 2;
        return false;
        
    }
    
}