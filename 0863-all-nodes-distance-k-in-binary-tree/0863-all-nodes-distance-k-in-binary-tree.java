/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent =new HashMap<>();
        buildmap(parent,null,root);
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> set=new HashSet<>();
        int dist=0;
        q.offer(target);
        set.add(target);
        while(!q.isEmpty()){
            int size=q.size();
            if(k==dist){
                List<Integer> ans=new ArrayList<>();
                for(TreeNode queue:q){
                    ans.add(queue.val);
                }
                return ans;

            }
            for(int i=0;i<size;i++){
                TreeNode node =q.poll();
                if(node.left!=null&&!set.contains(node.left)){
                    set.add(node.left);
                    q.offer(node.left);

                }
                  if(node.right!=null&&!set.contains(node.right)){
                    set.add(node.right);
                    q.offer(node.right);
                }
                if(parent.get(node)!=null&&!set.contains(parent.get(node))){
                    set.add(parent.get(node));
                    q.offer(parent.get(node));
                }

            }
            dist++;
        }
        return new ArrayList<>();
        
    }
    public void buildmap(Map<TreeNode,TreeNode> parent,TreeNode par,TreeNode child){
        if(child==null)return ;
        parent.put(child,par);
        buildmap(parent,child,child.left);
        buildmap(parent,child,child.right);


    }
}