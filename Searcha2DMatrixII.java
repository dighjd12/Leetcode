
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

For example, consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.


public boolean searchMatrix(int[][] matrix, int target) {
    int m=matrix.length-1;
    int n=matrix[0].length-1;
 
    int i=m; 
    int j=0;
 
    //by traversing in this way,
    //we can do "binary search" by casing whether the target is less or target is greater
    //than the current value.
    while(i>=0 && j<=n){
        if(target < matrix[i][j]){
            i--; //not this row
        }else if(target > matrix[i][j]){
            j++; //not this column
        }else{
            return true;
        }
    }
 
    return false;
}