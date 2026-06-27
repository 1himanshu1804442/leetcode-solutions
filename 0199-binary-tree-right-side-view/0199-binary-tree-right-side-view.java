/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(0,root,res);
        return res;
        
    }
    public void dfs(int level,TreeNode root,List<Integer> res){
        if(root==null)return;
        if(level==res.size()){
            res.add(root.val);
        }
        dfs(level+1,root.right,res);
        dfs(level+1,root.left,res);
    }
}