
In computer science, the longest common substring problem is to find the longest string that is a substring of two or more strings.

public static int getLongestCommonSubstring(String a, String b){
	int m = a.length();
	int n = b.length();
 
	int max = 0;
 
	int[][] dp = new int[m][n]; //dp[i][j] longest substring that ends at i, j. if the chars are diff, 0.
 
	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){
			if(a.charAt(i) == b.charAt(j)){
				if(i==0 || j==0){
					dp[i][j]=1;
				}else{
					dp[i][j] = dp[i-1][j-1]+1;
				}
 
				if(max < dp[i][j])
					max = dp[i][j];
			}
 
		}
	}
 
	return max;
}