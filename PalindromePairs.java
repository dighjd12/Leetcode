
Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]



public class Solution {
    
    public boolean isPalindrome(String s){
        String rev = new StringBuilder(s).reverse().toString();
        return rev.equals(s);
        
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        
        HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();
        HashMap<String, Integer> revMap = new HashMap<String, Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (int i=0; i<words.length; i++){
            wordsMap.put(words[i], i);
            revMap.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        
        for (int i=0; i<words.length; i++){
        
            String word = words[i];
            for(int j=0; j<=word.length(); j++){
                

                //current prefix = reverse of some word and rest are palindrom,
                //palindrome = word + the other word
                if (revMap.containsKey(word.substring(0,j)) && isPalindrome(word.substring(j))){
            
                    int pair = revMap.get(word.substring(0,j));
                    if (pair != i){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(pair);
                        res.add(list);
                        
                    }
                }
                
            }
        
             word = new StringBuilder(words[i]).reverse().toString();
            for(int j=0; j<=word.length(); j++){
                
                //current reverse of suffix = some word and rest are palindrome,
                //palindrome = the other word + reverse(word)
                if (wordsMap.containsKey(word.substring(0,j)) && isPalindrome(word.substring(j))){
                    if (j!=word.length()){
                        int pair = wordsMap.get(word.substring(0,j));
                        if (pair != i){
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(pair);
                            list.add(i);
                            res.add(list);
                            
                            
                        }
                    }
                    
                    
                    
                }
                
            }
       
            
        }
        
        return res;
        
    }
}