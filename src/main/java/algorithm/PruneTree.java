package algorithm;

/**
 * https://leetcode.com/problems/binary-tree-pruning/
 */
// TODO
public class PruneTree {

    public static TreeNode pruneTree(TreeNode root){
        if(root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.right == null && root.left == null && root.val == 0){
            return null;
        }
        return root;
    }
}
