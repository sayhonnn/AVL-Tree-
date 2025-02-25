package treetest;

public class TreeNode {

    protected TreeNode left;   // left node
    protected Object data;     // data item
    protected TreeNode right;  // right node
    int key;

    public TreeNode(int newData) {
        key = newData;
        data = newData;
        left = right = null;
    }

    public synchronized void insert(Integer number) {
        // new value is less than the node's data's value
        if (number.intValue() < ((Integer) data).intValue()) {
            if (left == null) {
                left = new TreeNode(number);
            } else {
                left.insert(number);
            }
            System.out.println("\n" + number + " Insert into tree.");
        } // assignment operator allows duplicate values
        else if (number.intValue() > ((Integer) data).intValue()) {
            if (right == null) {
                right = new TreeNode(number);
            } else {
                right.insert(number);
            }
            System.out.println("\n" + number + " Insert into tree.");
        } else {
            System.out.println("Error:" + number + " already exist in BST.");

        }

    }

    public synchronized int setKey(int key) {
        this.key = key;
        return key;
    }

    //set right child
    public synchronized TreeNode setRight(TreeNode right) {
        this.right = right;
        return right;
    }

    //set left child
    public synchronized TreeNode setLeft(TreeNode left) {
        this.left = left;
        return left;
    }

    //set data
    public synchronized TreeNode setData(TreeNode data) {
        this.data = data;
        return data;
    }

    public synchronized int getKey() {
        return key;
    }

    // get right child
    public synchronized TreeNode getRight() {
        return right;
    }

    // get left child
    public synchronized TreeNode getLeft() {
        return left;
    }

    // return the data
    public synchronized Object getData() {
        return data;
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int count = 1;
            count += countNodes(root.left);
            count += countNodes(root.right);
            return count;
        }
    }

}
