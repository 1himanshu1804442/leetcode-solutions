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
    private int preindex=0;
    Map<Integer,Integer> index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<inorder.length;i++){
            index.put(inorder[i],i);
        }
       return construct(preorder,0,n-1);
         

        
    }
    public TreeNode construct(int[] preorder,int start,int end){
        if(start>end)return null;
        int root=preorder[preindex++];
        TreeNode node=new TreeNode(root);
        int nodeindex=index.get(root);
         node.left=construct(preorder,start,nodeindex-1);
        node.right=construct(preorder,nodeindex+1,end);
        return node;

    }
}