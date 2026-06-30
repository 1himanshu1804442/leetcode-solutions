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
 public class BSTiterator{
    public boolean reverse;
   public Stack<TreeNode> st=new Stack<TreeNode>();

    public BSTiterator(TreeNode node,boolean isreverse){
    this.reverse=isreverse;
        pushall(node);

    }
    public boolean hasNext(){
        return !st.isEmpty();
    }
    public int next(){
        TreeNode temp=st.pop();
        if(reverse==false){
            pushall(temp.right);
        }
        else{
            pushall(temp.left);
        }
        return temp.val;
    }
    public void pushall(TreeNode node){
        while(node!=null){
            st.push(node);
            if(reverse==true){
                node=node.right;
            }
            else{
                node=node.left;
            }
            
        }
    }
 }
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        
        if(root==null)return false;
        BSTiterator l=new BSTiterator(root,false);
        BSTiterator r=new BSTiterator(root,true);
        int i=l.next();
        int j=r.next();
        while(i<j){
            if((i+j)==k){
                return true;
            }
            else if((i+j)<k){
                i=l.next();
            }
            else{
                j=r.next();
            }
        }
        return false;

    }
}