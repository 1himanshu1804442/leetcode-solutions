class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();

         helper(n,"",res,0,0);
         return res;
    }
    public void helper(int n,String curr,List<String> res,int open,int close){
        if(curr.length()==2*n){
            res.add(curr);
            return;
        }
        if(open<n){
            helper(n,curr+"(",res,open+1,close);

        }
        if(close<open){
            helper(n,curr+")",res,open,close+1);

        }

    }
}