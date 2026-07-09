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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        serialize(root,s);
        System.out.println(s.toString());
        return s.toString();
        
        
    }
    private void serialize(TreeNode root, StringBuilder s){
        if(root == null){
            s.append("null,");
            return;
        }
        s.append(root.val).append(",");
        serialize(root.left,s);
        serialize(root.right,s);

    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList(Arrays.asList(data.split(",")));
        return deserialize(q);
        
    }
    private TreeNode deserialize(Queue<String> q){
        String val = q.poll();
        if(val.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;

    }
}
