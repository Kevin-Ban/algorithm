package algorithm;

public class IsUnivalTree {
    /***
     * https://leetcode.com/problems/univalued-binary-tree/
     * @return
     */
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node5;
        node3.right = node4;
        System.out.println(isUnivalTree(node1));
    }

    public static boolean isUnivalTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        if(root.left != null){
            if(root.left.val != root.val){
                return false;
            }
        }
        if(root.right != null){
            if(root.right.val != root.val){
                return false;
            }
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
