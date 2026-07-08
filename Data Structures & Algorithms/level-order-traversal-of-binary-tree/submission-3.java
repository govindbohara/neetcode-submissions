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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        Deque<TreeNode> q = new ArrayDeque();

        if(root == null) return res;
        q.addLast(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList();
            for(int i = 0; i< size; i++){
                TreeNode n = q.removeFirst();
                l.add(n.val);
                if(n.left != null){
                    q.addLast(n.left);
                }
                if(n.right != null){
                    q.addLast(n.right);
                }
            }
            res.add(l);
        }
        return res;

    }
}
