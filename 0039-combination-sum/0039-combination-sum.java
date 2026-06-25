class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        helper(candidates,target,0,list,res);
        return res;

        
    }
    public void helper(int[] candidates,int target,int index,List<Integer> list,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(target<0||index==candidates.length){
            return;
        }
        list.add(candidates[index]);
        helper(candidates,target-candidates[index],index,list,res);
        list.remove(list.size()-1);
        helper(candidates,target,index+1,list,res);
    }
}