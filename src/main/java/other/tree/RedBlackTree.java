package other.tree;

public class RedBlackTree {

    public static final int red = 1;

    public static final int black = 2;

    private Node root;

    class Node {

        private Node left;

        private Node right;

        private Node parent;

        private int data;

        int color = red;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insert(Node root, int data) {
        if (root.data < data) {
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                insert(root.right, data);
            }
        }
        if (root.data > data) {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                insert(root.left, data);
            }
        }
    }

    public void leftRoate(Node node) {

    }

    public void rightRoate(Node node) {

    }


}
