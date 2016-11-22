An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.

public class Solution {
    
    int lowR = 0;
    int lowC = 0;
    int highR = 0;
    int highC = 0;
    
    public int minArea(char[][] image, int x, int y) {
        
        int r = image.length;
        int c = image[0].length;
        int[][] visited = new int[r][c];
        
        highR = x; lowR = x;
        highC = y; lowC = y;
        
        helper(image, x, y, visited);
        
        return (highC-lowC+1)*(highR-lowR+1);
        
    }
    
    public void helper(char[][] image, int x, int y, int[][] visited){
        
        if (x<0 || y<0 || x>=image.length || y>= image[0].length) return;
        if (visited[x][y] == 1) return;
        if (image[x][y] == '0') return;
        
        visited[x][y] = 1;
        
        if (x < lowR) lowR = x;
        if (y < lowC) lowC = y;
        if (x > highR) highR = x;
        if (y > highC) highC = y;
        
        helper(image, x+1, y, visited);
        helper(image, x-1, y, visited);
        helper(image, x, y+1, visited);
        helper(image, x, y-1, visited);
        
    }
    
}