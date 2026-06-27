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
    static class Point{
        int row;
        int col;
        int val;
        public Point(int row,int col,int val){
            this.row=row;
            this.col=col;
            this.val=val;

        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Point> allnodes=new ArrayList<>();
        dfs(root,allnodes,0,0);
        Collections.sort(allnodes,(a,b)->{
            if(a.col!=b.col)return a.col-b.col;
            if(a.row!=b.row)return a.row-b.row;
           return a.val-b.val;

        });
        Integer prevcol=null;
        for(Point p:allnodes){
            if(prevcol==null||p.col!=prevcol){
                res.add(new ArrayList<>());
                prevcol=p.col;
            }
            res.get(res.size()-1).add(p.val);

        }
        return res;
        
    }
    public void dfs(TreeNode root,List<Point> allnodes,int col,int row){
        if(root==null)return ;
        allnodes.add(new Point(row,col,root.val));
        dfs(root.left,allnodes,col-1,row+1);
        dfs(root.right,allnodes,col+1,row+1);

    }
}