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
    class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node,int num){
            this.node=node;
            this.num=num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        int ans=0;
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int mmin=q.peek().num;
            int size=q.size();
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                TreeNode curr=q.peek().node;
                int currid=(q.peek().num)-mmin;
                q.poll();
                if(i==0)first=currid;
                if(i==size-1)last=currid;
                if(curr.left!=null){
                    q.offer(new Pair(curr.left,2*currid+1));
                }
                if(curr.right!=null)
                q.offer(new Pair(curr.right,2*currid+2));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
        
    }
}