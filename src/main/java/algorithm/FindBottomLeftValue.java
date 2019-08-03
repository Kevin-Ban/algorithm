package algorithm;

import java.util.ArrayList;
import java.util.List;

public class FindBottomLeftValue {

    public static int findBottomLeftValue(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        getLeft(root, list);
        return list.get(list.size() - 1);
    }

    public static void getLeft(TreeNode root, List<Integer> result){
        
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        findBottomLeftValue(node);
    }
}
