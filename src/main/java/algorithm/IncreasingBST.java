package algorithm;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingBST {
// TODO
    public static TreeNode increasingBST(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.right != null && root.right.val > root.val){
            root.left = null;
        }
        return null;
    }
}
