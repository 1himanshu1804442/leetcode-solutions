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
    int maxi;

    public int maxPathSum(TreeNode root) {
        maxi = Integer.MIN_VALUE;
         solve(root);
         return maxi ;


    }

    public int solve(TreeNode root) {
        if (root == null)
            return 0;
        int lh = Math.max(0, solve(root.left));
        int rh = Math.max(0, solve(root.right));
        int currsum = lh + rh + root.val;
        maxi = Math.max(maxi, currsum);
        return root.val + Math.max(lh, rh);
    }
}