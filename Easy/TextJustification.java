
Given an array of words and a length L, 
format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; 
that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line do not divide evenly between words, 
the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.



public class Solution {
    
    public String generateSpace(int numSpaces){
        String res = "";
        for (int i=0; i<numSpaces; i++){
            res += " ";
        }
        return res;
    }
    
    public void justify(List<String> line, List<String> res, int numSpaces){
        
        if (line.size()==0){
            res.add("");
            return;
        }
        
        if (line.size()==1){
            res.add(line.get(0) + generateSpace(numSpaces));
            return;
        }
        
        int blanks = line.size()-1;
        int avgSpace = numSpaces/blanks;
        int remainder = numSpaces % blanks;
        
        StringBuilder sb = new StringBuilder();
        sb.append(line.get(0));
        for (int i=1; i<line.size(); i++){
            
            String s = line.get(i);
            int add = remainder > 0 ? 1 : 0;
            sb.append(generateSpace(avgSpace+add)).append(s);
            remainder--;
            
        }
        
        res.add(sb.toString());
        
    }
    
    public void leftjustify(List<String> line, List<String> res, int numSpaces){
        
        StringBuilder sb = new StringBuilder();
        sb.append(line.get(0));
        for (int i=1; i<line.size(); i++){
            
            String s = line.get(i);
            sb.append(" ").append(s);
            numSpaces--;
            
        }
        sb.append(generateSpace(numSpaces));
        res.add(sb.toString());
        
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> res = new ArrayList<String>();
        if (maxWidth==0){
            for (int i=0; i<words.length; i++){
                res.add("");
            }
            return res;
        }
        
        List<String> line = new ArrayList<String>();
        int size=0;
        int j=0;
        while (j<words.length){
            
            //candidate size with jth word added
            int num = size + words[j].length() + line.size();
            if (num < maxWidth){
                
                size+= words[j].length();
                line.add(words[j]);
                
            }else if (num == maxWidth){

                //justify this line
                line.add(words[j]);
                size += words[j].length();
                justify(line, res, maxWidth-size);
                line = new ArrayList<String>();
                size = 0;
                
            } else{
                
                //exceeds, then justify this line without the current elem
                justify(line, res, maxWidth-size);
                //initialize the next line with current elem
                line = new ArrayList<String>();
                line.add(words[j]);
                size = words[j].length();
                
            }
            
            j++;
        }
        
        if (!line.isEmpty()) leftjustify(line, res, maxWidth-size);
        
        return res;
        
    }
}