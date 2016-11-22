Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]


public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n: nums){
            if (map.containsKey(n)){
                map.put(n, map.get(n)+1);
            }else{
                map.put(n, 1);
            }
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        permute(map, new ArrayList<Integer>(), res);
        
        return res;
    }
    
    public void permute(Map<Integer, Integer> map, List<Integer> curr, List<List<Integer>> res){
        
        if (map.isEmpty()){
            res.add(new ArrayList<Integer>(curr));
        }
        
        Set<Integer> set = map.keySet();
        //int elem;
        for (int n: set){
            Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(map);
            if (map2.get(n) > 1){
                map2.put(n, map2.get(n)-1);
            }else{
                map2.remove(n);
            }
            curr.add(n);
            permute(map2, curr, res);
            curr.remove(curr.lastIndexOf(new Integer(n)));
        }
        
        
    }
    
}