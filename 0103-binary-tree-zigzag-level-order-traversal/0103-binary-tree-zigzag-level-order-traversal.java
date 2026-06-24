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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();

        }
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        q.offer(root);
        boolean flag=false;
        while(!q.isEmpty()){
            int currlevel=q.size();
            List<Integer> st=new ArrayList<>();
            Stack<Integer> reversest=new Stack<>();
            for(int i=0;i<currlevel;i++){
                TreeNode node=q.poll();
                if(flag){
                    reversest.add(node.val);
                }
                else{
                    st.add(node.val);
                }
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            flag=!flag;
            while(!reversest.isEmpty()){
                st.add(reversest.pop());
            }
            list.add(st);
        }
        return list;
        
    }
}