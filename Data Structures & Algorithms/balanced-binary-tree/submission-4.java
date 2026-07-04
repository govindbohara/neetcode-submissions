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
    boolean b = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return b;
    }

    public int height(TreeNode root){
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        if(Math.max(left,right)-Math.min(left,right) >1){
            b = false;
        }
        return 1 + Math.max(left,right);
    }
}
