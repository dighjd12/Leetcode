Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. 
A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.


public class WordDictionary {

    class Trie{
        Trie[] arr = new Trie[26];
        boolean end = false;
        public Trie(){
        }
        
    }

    Trie root = new Trie();

    // Adds a word into the data structure.
    public void addWord(String word) {
        
        Trie curr = root;
        for (int i =0; i<word.length(); i++){
            
            int c = word.charAt(i) - 'a';
            if (curr.arr[c] == null){
                Trie next = new Trie();
                curr.arr[c] = next;
                curr = next;
            }else{
                curr = curr.arr[c];
            }
            
            if (i==word.length()-1){
                curr.end = true;
            }
            
        }
        
        
        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        
        //dfs
        return searchHelp(word, 0, root);
        
    }
    
    public boolean searchHelp(String word, int idx, Trie t){
        
        
        if (idx == word.length()){
            return t.end;
        } 
        
        char c = word.charAt(idx);
        
        if (c == '.'){
            
            for (int i=0; i<26; i++){
                
                Trie cand = t.arr[i];
                
                if (cand != null) {
                    
                    boolean b = searchHelp(word, idx+1, cand);
                    if (b) return true;
                    
                }
                
            }
            
        }else {
            
            int i = c - 'a';
            if (t.arr[i] == null) return false;
            
            return searchHelp(word, idx+1, t.arr[i]);
            
        }
        
        return false;
        
    }
    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");