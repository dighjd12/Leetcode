
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

Complexity: O(n)

public class Solution {
    
    public static int longestValidParentheses(String s) {
    	Stack<int[]> stack = new Stack<int[]>();
    	int result = 0;

    	for(int i=0; i<=s.length()-1; i++){
    		char c = s.charAt(i);
    		if(c=='('){
    			int[] a = {i,0}; //(index, '(')
    			stack.push(a);
    		}else{
    			if(stack.empty()||stack.peek()[1]==1){ 
                    //update the stack such that if current ')' is not matched, then
                    //we know that the previous running valid pairs should be 'reaped'
                    //put a into stack to indicate this. (these will never be popped)
    				int[] a = {i,1}; //(index, ')') //unmatched ')'
    				stack.push(a);
    			}else{
    				stack.pop(); //valid matching '(' for the current ')'
    				int currentLen=0;
    				if(stack.empty()){
    					currentLen = i+1; //all valid pairs so far
    				}else{
    					currentLen = i-stack.peek()[0]; //update length!
    				}
    				result = Math.max(result, currentLen);
    			}
    		}
    	}
     
    	return result;
    }
    
    /*
    public int longestValidParentheses(String s) {
        
        System.out.println("*****************");
        Stack<int[]> stack = new Stack<int[]>();
        int res = 0;
        int curr = 0;
        int lastIdx = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                res = Math.max(curr, res);
                
                int[] elem = {i, curr};
                stack.push(elem);
            }else {
                
                if (stack.empty()){
                    res = Math.max(curr,res);
                    curr = 0;
                }else {
                    stack.pop();
                    curr += 2;
                    
                }
                
                lastIdx = i;
                
            }
            
            System.out.println("at index: " + i + " current " + curr);
            
        }
        
        
        int prev = -1;
        while (!stack.empty()){
            int[] m = stack.pop();
            if (m[0] < lastIdx && m[1] != prev){
                curr -= m[1];
                prev = m[1];
                break;
            }
            
        }
        
        res = Math.max(curr, res);
        
        return res; 
        
        
    }*/
}