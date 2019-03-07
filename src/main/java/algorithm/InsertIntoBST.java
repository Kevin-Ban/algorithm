package algorithm;

public class InsertIntoBST {

    public static void main(String[] args){
        // TODO
    }
    public static TreeNode insertIntoBST(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }
        if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
