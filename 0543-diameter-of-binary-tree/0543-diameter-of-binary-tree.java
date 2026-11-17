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
    int diameter=0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);

        return diameter;
    }

    private int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        diameter=Math.max(diameter,leftHeight+rightHeight);

        return 1 + Math.max(leftHeight,rightHeight);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna