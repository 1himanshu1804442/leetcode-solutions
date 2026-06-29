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
    private int postIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        postIndex = postorder.length - 1;
        
        return construct(postorder, 0, inorder.length - 1);
    }
    
    private TreeNode construct(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = inorderMap.get(rootVal);
        
        root.right = construct(postorder, rootIndex + 1, inEnd);
        root.left = construct(postorder, inStart, rootIndex - 1);
        
        return root;
    }
}