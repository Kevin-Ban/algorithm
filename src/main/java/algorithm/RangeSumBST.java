package algorithm;

public class RangeSumBST {

    /**
     * https://leetcode.com/problems/range-sum-of-bst/
     *
     */

    public static void main(String[] args){

    }

    public static int rangeSumBST(TreeNode root, int L, int R){
        // 当节点为null，返回0
        if(root == null){
            return 0;
        }
        // 当前的值小于前一个数，进入右子节点点
        if(root.val < L){
            return rangeSumBST(root.right, L, R);
        }
        // 当前的值大于后一个属，禁入左子节点
        if(root.val > R){
            return rangeSumBST(root.left, L, R);
        }
        // 当前的值大于等于L,小于等于R时，将数加起来
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    /**
     * Definition for a binary other.tree node.
     *
     */
     class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }
}
