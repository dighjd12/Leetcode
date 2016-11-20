Assume you have an array of length n initialized with all 0s and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

public int[] getModifiedArray(int length, int[][] updates) {
    int[] result = new int[length];
    if(updates==null||updates.length==0)
        return result;
 
    for(int i=0; i<updates.length; i++){
        result[updates[i][0]] += updates[i][2]; //add inc from the startIndex to the end
        if(updates[i][1]<length-1){
            result[updates[i][1]+1] -=updates[i][2]; //add -inc from the endIndex to the end
        }
    }
 
    int v=0;
    for(int i=0; i<length; i++){
        v += result[i];
        result[i]=v;
    }
 
    return result;
}